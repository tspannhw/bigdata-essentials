package com.needforcode.mapreduce.reducejoin;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReduceJoinReducer extends Reducer<Text,Text,Text,NullWritable>{

    private static String person;
    private static String personDiagnosis;
    Text outKey = new Text();
    NullWritable outValue = NullWritable.get();

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
        throws IOException, InterruptedException {

        person = null;
        personDiagnosis = null;

        for (Text value : values) {
            if (value.charAt(0) == 'A') {
                person = value.toString().substring(1);
            } else if (value.charAt(0) == 'B') {
                personDiagnosis = value.toString().substring(1);
            }
        }

        outKey.set(person+","+personDiagnosis);

        if(personDiagnosis != null)
        context.write(outKey,outValue);
    }
}
