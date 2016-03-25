package com.bigdataguide.spark

import org.apache.spark.{SparkContext, SparkConf}

object WordCount {
  
  def main(args: Array[String]) {
    
    val inputDir1 = args(0) // input dir to read data from
    val inputDir2 = args(1) // input dir to read data from

    val outputDir1 = args(2) // output dir to store results.
    val outputDir2 = args(3) // output dir to store results.

    
    val conf = new SparkConf().setAppName("WordCount Example")
    
    val sc = new SparkContext(conf) // streaming context for spark job.
    
    val inputRDD1 =  sc.textFile(inputDir1)
    val inputRDD2 =  sc.textFile(inputDir2)

    
    val tupleRdd1 = inputRDD1.map( x => (x.split(",")(0),x.split(",")(1)))
    val tupleRdd2 = inputRDD2.map( x => (x.split(",")(0),x.split(",")(1)))

    
    tupleRdd1
    
  }
}
