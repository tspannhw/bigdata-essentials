package com.bigdataguide.mapreduce.reducejoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.Logger;

public class ReduceJoinDriver {

    private static Logger logger = Logger.getLogger(ReduceJoinDriver.class);

    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            logger.error("Usage : pass the args <person path> <person diag path> <output path>");
            System.exit(0);
        }

        Configuration conf = new Configuration();

        // Populate the configuration details.
        Job job = new Job(conf, "Reduce Join");
        job.setJarByClass(ReduceJoinDriver.class);

        MultipleInputs.addInputPath(job, new Path(args[0]),TextInputFormat.class,PersonMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]),TextInputFormat.class, PersonDiagnosisMapper.class);

        job.setReducerClass(ReduceJoinReducer.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
