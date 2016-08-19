package com.needforcode.scrunch.pipeline

import org.apache.crunch.scrunch.PipelineApp

object JoinsPipeline extends PipelineApp {

  def joinDataSets(path1: String, path2 : String) = {
    val collection1 = read(from.textFile(path1))
    val collection2 = read(from.textFile(path2))
    collection1.map(line => (line.split(",")(0), line)).join(collection2.map(line => (line.split(",")(0), line)))    
  }
  
  override def run(args: Array[String]) {
    joinDataSets(args(0), args(1)).write(to.textFile(args(2)))
  }
}
