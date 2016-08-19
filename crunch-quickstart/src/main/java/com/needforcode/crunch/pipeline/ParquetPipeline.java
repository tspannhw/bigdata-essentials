package com.needforcode.crunch.pipeline;

import java.io.File;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData.Record;
import org.apache.crunch.PCollection;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.io.To;
import org.apache.crunch.io.parquet.AvroParquetFileSource;
import org.apache.crunch.types.avro.Avros;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ParquetPipeline extends Configured implements Tool {

  public static void main(String[] args) throws Exception {
    ToolRunner.run(new Configuration(), new ParquetPipeline(), args);
  }

  public int run(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Usage: hadoop jar crunch-demo-1.0-SNAPSHOT-job.jar"
                                      + " [generic options] input output");
            System.err.println();
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath = args[0];
        String outputPath = args[1];
        
        // read the schema file
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("schema/orders.avsc").getFile());
        
        // prepare schema object from avsc.
        Schema schema = new Schema.Parser().parse(file);
        
        Path inPath = new Path(inputPath);
        
        Pipeline pipeline = new MRPipeline(ParquetPipeline.class, getConf());
        
        PCollection<Record> records = pipeline.read(new AvroParquetFileSource<Record>(inPath, Avros.generics(schema)));
        
        //pipeline.write(records,new AvroParquetFileTarget(outputPath));
        
        PTable<Record, Long> count = records.count();
        
        count.write(To.textFile(outputPath));

        PipelineResult result = pipeline.done();
        
        return result.succeeded() ? 0 : 1;
    }
}
