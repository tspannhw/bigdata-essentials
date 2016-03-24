package com.bigdataguide.mapreduce.mapjoin;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapJoinMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private static HashMap<String, String> personDiagnosis = new HashMap<>();
    private BufferedReader reader;
    private static String personId;
    private static String personDiagnosisCode;
    private Text outputKey = new Text("");
    NullWritable outputValue = NullWritable.get();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        Path[] cache = DistributedCache.getLocalCacheFiles(context.getConfiguration());

        for (Path path : cache) {
            if (path.getName().toString().trim().contains("person_diagnosis.csv")) {
                try {
                    reader = new BufferedReader(new FileReader(path.toString()));
                    String line;

                    // Read each line, split and load to HashMap
                    while ((line = reader.readLine()) != null) {
                        String diagArray[] = line.split(",",-1);
                        personDiagnosis.put(diagArray[0].trim(), diagArray[1].trim());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new IOException(e);
                } finally {
                    if (reader != null) {
                        reader.close();
                    }
                }
            }
        }
    }

    @Override
    public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {

        if (value.toString().length() > 0) {
            String personArray[] = value.toString().split(",",-1);

            personId = personArray[0];

            personDiagnosisCode = personDiagnosis.get(personId);

            outputKey.set(value.toString()+","+personDiagnosisCode);

            if (personDiagnosisCode != null) {
                context.write(outputKey, outputValue);
            }
        }

    }
}
