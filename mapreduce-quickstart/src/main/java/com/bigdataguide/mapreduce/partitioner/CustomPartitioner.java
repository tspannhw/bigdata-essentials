package com.bigdataguide.mapreduce.partitioner;

import org.apache.hadoop.io.Text;

public class CustomPartitioner extends org.apache.hadoop.mapreduce.Partitioner< Text, Text >
{
    @Override
    public int getPartition(Text key, Text value, int numReduceTasks)
    {
        int id = Integer.parseInt(key.toString());

        if(numReduceTasks == 0)
        {
            return 0;
        } else if (id > 0 && id <= 250){
            return 0;
        } else if (id > 250 && id <= 500) {
            return 1;
        } else if (id > 500 && id <= 750) {
            return 2;
        } else if (id > 750 && id <= 1000) {
            return 3;
        } else {
            return 0;
        }
    }
}
