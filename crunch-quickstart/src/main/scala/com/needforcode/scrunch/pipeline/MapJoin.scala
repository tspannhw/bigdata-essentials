package com.needforcode.scrunch.pipeline

import org.apache.crunch.scrunch.PipelineApp
import org.apache.crunch.scrunch.Joins

object MapJoinPipeline extends PipelineApp {

  def mapjoinDataSets(path1: String, path2 : String) = {
    val collection1 = read(from.textFile(path1))
    val collection2 = read(from.textFile(path2))
    collection1.map(line => (line.split(",")(0), line)).innerJoinUsing(collection2.map(line => (line.split(",")(0), line)), Joins.mapside())    
  }
  
  override def run(args: Array[String]) {
    mapjoinDataSets(args(0), args(1)).write(to.textFile(args(2)))
  }
}
