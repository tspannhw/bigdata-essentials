package com.needforcode.mapreduce.partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.math.BigDecimal;

public class ReduceClass extends Reducer<Text,Text,Text,Text>
{
    public static BigDecimal sum = BigDecimal.ZERO;
    public void reduce(Text key, Iterable <Text> values, Context context) throws IOException, InterruptedException
    {

        for (Text val : values)
        {
            String [] str = val.toString().split(",", -1);
            sum = sum.add(new BigDecimal(str[5]));
        }

        context.write(new Text(key), new Text(sum.toPlainString()));
    }
}
