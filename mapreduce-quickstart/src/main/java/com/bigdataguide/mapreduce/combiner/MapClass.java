package com.bigdataguide.mapreduce.combiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapClass extends Mapper<LongWritable,Text,Text,Text>
{

    private static String gender;
    private static String salary;

    public void map(LongWritable key, Text value, Context context)
    {
        try{
            String[] str = value.toString().split(",", -1);
            gender=str[4];
            salary = str[5];
            context.write(new Text(gender), new Text(salary));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
