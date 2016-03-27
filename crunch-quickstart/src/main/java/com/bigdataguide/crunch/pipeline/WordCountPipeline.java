package com.bigdataguide.crunch.pipeline;

import com.bigdataguide.crunch.dofn.Tokenizer;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.crunch.PCollection;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.PipelineResult.StageResult;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.File;


/**
 * A word count example for Apache Crunch
 */
public class WordCountPipeline extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new Configuration(), new WordCountPipeline(), args);
    }

    public int run(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("hadoop jar Crunch-Examples-0.0.1-SNAPSHOT.jar org.w2b.crunch.pipeline.WordCountPipeline <input> <output>");
            System.err.println();
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        // Create an object to coordinate pipeline creation and execution.
        Pipeline pipeline = new MRPipeline(WordCountPipeline.class, getConf());

        // Reference a given text file as a collection of Strings.
        PCollection<String> lines = pipeline.readTextFile(inputPath);

        //splits each line in a PCollection of Strings into a PCollection made up of the individual words in the file.
        PCollection<String> words = lines.parallelDo(new Tokenizer(), Writables.strings());

        PTable<String, Long> counts = words.count();

        pipeline.writeTextFile(counts, outputPath);
        
        // Execute the pipeline as a MapReduce.
        PipelineResult result = pipeline.done();
        
        // writing the dot file for viewing execution graph
        String dot = pipeline.getConfiguration().get("crunch.planner.dotfile");
        Files.write(dot, new File("pipeline.dot"), Charsets.UTF_8);
        
        for (StageResult r : result.getStageResults()) {
        	System.out.println("stage1: " +r.getStageId());
        	System.out.println("stage2: "+r.getStageName());
        	System.out.println("stage3: "+r.toString());
        }

        return result.succeeded() ? 0 : 1;
    }
}
