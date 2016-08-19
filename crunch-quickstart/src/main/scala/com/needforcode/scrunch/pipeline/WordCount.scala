package com.needforcode.scrunch.pipeline

import org.apache.crunch.scrunch.PipelineApp

object WordCountScalaPipeline extends PipelineApp {

  def wordSplit(line: String) = line.split("\\W+").filter(!_.isEmpty())

  def countWords(filename: String) = {
    val lines = read(from.textFile(filename))
    val words = lines.flatMap(wordSplit)
    words.count
  }

  override def run(args: Array[String]) {
    countWords(args(0)).write(to.textFile(args(1)))
  }
}
