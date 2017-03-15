package com.needforcode.scrunch.pipeline

import org.apache.crunch.scrunch.PipelineApp
import org.apache.crunch.scrunch.Joins

object UnionPipeline extends PipelineApp {

  def cogroupDatasets(path1: String, path2 : String) = {
    val collection1 = read(from.textFile(path1))
    val collection2 = read(from.textFile(path2))
    collection1.union(collection2)   
  }
  
  override def run(args: Array[String]) {
    cogroupDatasets(args(0), args(1)).write(to.textFile(args(2)))
  }
}
