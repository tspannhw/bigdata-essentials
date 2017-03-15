package com.needforcode.mapreduce.mapjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.log4j.Logger;

/*
Driver class for map join in the map tasks using Distributed Cache.
 */
public class MapJoinDriver {

    private static Logger logger = Logger.getLogger(MapJoinDriver.class);

    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            logger.error("Usage : pass the args <person path> <person diag path> <output path>");
            System.exit(0);
        }

        Configuration conf = new Configuration();

        // Populate the configuration details.
        Job job = new Job(conf, "Map Join");
        job.setJarByClass(MapJoinDriver.class);

        job.setMapperClass(MapJoinMapper.class);
        job.setNumReduceTasks(0);

        TextInputFormat.setInputPaths(job, new Path(args[0]));
        TextOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // Adding small file to distributed cache.
        DistributedCache.addCacheFile(new Path(args[1]).toUri(),job.getConfiguration());

        DistributedCache.setLocalFiles(job.getConfiguration(), args[0]);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
