package com.bigdataguide.mapreduce.partitioner;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;

import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

import org.apache.hadoop.util.*;

public class PartitionerDriver extends Configured implements Tool {

    @Override
    public int run(String[] arg) throws Exception
    {
        Configuration conf = getConf();

        Job job = new Job(conf, "PartitionerExample");
        job.setJarByClass(PartitionerDriver.class);

        FileInputFormat.setInputPaths(job, new Path(arg[0]));
        FileOutputFormat.setOutputPath(job,new Path(arg[1]));

        job.setMapperClass(MapClass.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setPartitionerClass(CustomPartitioner.class);
        job.setReducerClass(ReduceClass.class);
        job.setNumReduceTasks(4);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        System.exit(job.waitForCompletion(true)? 0 : 1);
        return 0;
    }

    public static void main(String args[]) throws Exception
    {
        int res = ToolRunner.run(new Configuration(), new PartitionerDriver(),args);
        System.exit(0);
    }
}
