package com.bigdataguide.spark

import org.apache.spark.{SparkContext, SparkConf}

/*
 * Author: Vasu D
 */
object WC {
  
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("WordCount Example")
    
    val sc = new SparkContext(conf) // streaming context for spark job.
    
   val rdd1 = sc.parallelize(Array((1, "Apple"), (2, "Ball"), (3, "Cat")))
   val rdd2 = sc.parallelize(Array((2, "box"), (3, "Cam"), (4, "Dog"), (5,"Elephant")))
    
   val joined = rdd1.leftOuterJoin(rdd2)
   
   val filteredRDDOnlyLeft = joined.filter(x => !(x._2._2.isDefined)) // only left
   
   filteredRDDOnlyLeft.foreach(x => println(x))
   
   val filteredRDDCommon = joined.filter(x => (x._2._2.isDefined)) // common
   
   filteredRDDCommon.foreach(x => println(x))
   
   val join2 = rdd2.leftOuterJoin(rdd1)
   
   val filteredRDDOnlyRight = join2.filter(x => !(x._2._2.isDefined)) // only right
   
   filteredRDDOnlyRight.foreach(x => println(x))
   
   val rddOutput1 = filteredRDDOnlyLeft.union(filteredRDDOnlyRight).map(x => (x._1,x._2._1))
   val rddOutput2 = filteredRDDCommon.map(x => (x._1,x._2._2.get))
       
   val output = rddOutput1.union(rddOutput2).foreach(x => println(x))
   
  }
}
