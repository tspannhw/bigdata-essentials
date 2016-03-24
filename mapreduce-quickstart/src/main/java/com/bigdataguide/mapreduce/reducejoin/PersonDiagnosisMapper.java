package com.bigdataguide.mapreduce.reducejoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PersonDiagnosisMapper extends Mapper<Object, Text, Text, Text>{

    private Text outputKey = new Text();
    private Text outputValue = new Text();
    private static String personId;

    @Override
    public void map(Object key, Text value, Context context)
        throws IOException, InterruptedException {

        if (value.toString().length() > 0) {
            personId = value.toString().split(",")[0];
        }

        outputKey.set(personId);
        outputValue.set("B" + value.toString());

        context.write(outputKey, outputValue);
    }
}
