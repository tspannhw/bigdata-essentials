package com.needforcode.crunch.pipeline;

import com.needforcode.crunch.dofn.Tokenizer;
import org.apache.crunch.PCollection;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.PipelineResult.StageResult;
import org.apache.crunch.impl.spark.SparkPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.spark.api.java.JavaSparkContext;


/**
 * A word count example for Apache Crunch, based on Crunch's example projects.
 */
public class WordCountSparkPipeline extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new Configuration(), new WordCountSparkPipeline(), args);
    }

    public int run(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Usage: hadoop jar crunch-quickstart-1.0-SNAPSHOT.jar"
                                      + " [generic options] input output");
            System.err.println();
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath = args[0];
        String outputPath = args[1];
        
        JavaSparkContext context = new JavaSparkContext();

        Pipeline pipeline = new SparkPipeline(context, "com.needforcode.spark word count example");

        PCollection<String> lines = pipeline.readTextFile(inputPath);

        PCollection<String> words = lines.parallelDo(new Tokenizer(), Writables.strings());

        PTable<String, Long> counts = words.count();

        pipeline.writeTextFile(counts, outputPath);

        PipelineResult result = pipeline.done();
        
        for (StageResult r : result.getStageResults()) {
            System.out.println("stage1: " +r.getStageId());
            System.out.println("stage2: "+r.getStageName());
            System.out.println("stage3: "+r.toString());
        }

        return result.succeeded() ? 0 : 1;
    }
}
