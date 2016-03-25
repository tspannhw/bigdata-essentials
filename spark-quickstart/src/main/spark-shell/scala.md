
# Transformations in Spark

## aggregate
The aggregate can return a different type than RDD on which we are working on. It allows users to apply 2 functions, one on top of each partition (input type T => U), other to aggregate the results of all the partitions into final result (merging 2 U's). Both the functions have to be commutative and associative. We can also specify a initial value.

```
val inputRdd = sc.parallelize(Array(1,2,3,4,5,6,7))
val output = inputRdd.aggregate(0)((x,y) => x+y, (u,v) => u+v);
println(output)
28 
```

## cartesian
Return the Cartesian product of this RDD and another one. result contains all pairs of (a,b) where a belongs to rdd1 and b belongs to rdd2.

```
val rdd1 = sc.parallelize(1 to 2)
val rdd2 = sc.parallelize(3 to 5)
val output = rdd1.cartesian(rdd2).collect()
  
output: Array[(Int, Int)] = Array((1,3), (1,4), (1,5), (2,3), (2,4), (2,5))
```

## countByValue
Returns count of each unique value in this RDD as a local map of (value, count) pairs. Should be careful while using this when you have large data as it sends the results to driver.

```
val inputRdd = sc.parallelize(1 to 10)
val output = inputRdd.countByValue()
println(output)
  
Map(5 -> 1, 10 -> 1, 1 -> 1, 6 -> 1, 9 -> 1, 2 -> 1, 7 -> 1, 3 -> 1, 8 -> 1, 4 -> 1) 
```

## collect
Used only when the rdd is small enough. Return an array that contains all of the elements in this RDD.

```
val output = sc.parallelize(1 to 10, 2).collect()
 
output: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 
```

## distinct
Return a new RDD containing the distinct elements in this RDD. Shuffle happens on this transformation.

```
val data = Seq(1,1,2,2,3,4)
val inputRdd = sc.parallelize(data)
val output = inputRdd.distinct();
output.collect()
 
Result: res0: Array[Int] = Array(4, 2, 1, 3)
```

## filter
Return a new RDD containing only the elements that satisfy a predicate.

```
val data = Seq(1, 2, 3, 4)
val inputRdd = sc.parallelize(data)
val filterOutput = inputRdd.filter( s => s>2 )
filterOutput.collect();
  
Result: res0: Array[Int] = Array(3, 4)
```

## first
Return the first element in this RDD.

```
val output = sc.parallelize(1 to 10).first();
output: Int = 1 
```

flatMap
Return a new RDD by first applying a function to all elements of this RDD, and then flattening the results.
You need to supply (A ⇒ Iterable[B]) function to the flatMap i.e on each element of input A, Map is applied followed by flatten which is flatMap.

```
val data = Seq(1, 2, 3, 4)
val inputRdd = sc.parallelize(data)
val output = inputRdd.flatMap( s => List(s,s+1,s+2));
output.collect();
  
Result: res0: Array[Int] = Array(1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)
```

## glom
Return an RDD created by coalescing all elements within each partition into an array.

```
val inputRdd = sc.parallelize(1 to 10, 2)
val output = inputRdd.glom().collect();
  
output: Array[Array[Int]] = Array(Array(1, 2, 3, 4, 5), Array(6, 7, 8, 9, 10)) 
```

## groupBy
*Return an RDD of grouped items.
*Each group consists of a key and a sequence of elements mapping to that key.
*Ordering is not guaranteed, not same for every execution.
*Shuffle happens, better to use reduceby than groupby since it does not combine in each partition itself ( i.e groupBy happens in reduce phase), hence result high network traffic.

```
val rdd1 = sc.parallelize(Array(2,3,4,1,3,4))
val output = rdd1.groupBy(x => x).collect()
  
output: Array[(Int, Iterable[Int])] = Array((4,CompactBuffer(4, 4)), (2,CompactBuffer(2)), (1,CompactBuffer(1)), (3,CompactBuffer(3, 3)))
```

## intersection
*Return the intersection of this RDD and another one.
*Result will not contain any duplicate.
*Done by map, co-group, filter in the background.
*performs a shuffle internally
 
```
val output = sc.parallelize(Array(1,2,3,4))
               .intersection(sc.parallelize(Array(3,4,5,6)))
               .collect()
  
output: Array[Int] = Array(4, 3)
```

## map
Return a new RDD by applying a function to all elements of this RDD

```
val data = Seq(1, 2, 3, 4)
val inputRdd = sc.parallelize(data)
val output = inputRdd.map( s => s+1 ) // applying anonymus function to rdd elements.
output.collect();  
 
Result: res0: Array[Int] = Array(2, 3, 4, 5)
```

## mapPartitions
Return a new RDD by applying a function to each partition of this RDD. 

```
val rdd1 = sc.parallelize(1 to 20,3)
val output = rdd1.mapPartitions(x => x).collect();
 
output: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
```

## mapPartitionsWithIndex
Similar to mapPartitions, additionally tracks the index of the original partition.

```
val inputRdd = sc.parallelize(1 to 10, 2)
val output = inputRdd.mapPartitionsWithIndex((idx, itr) => itr.map(s => (idx, s))).collect()
  
output: Array[(Int, Int)] = Array((0,1), (0,2), (0,3), (0,4), (0,5), (1,6), (1,7), (1,8), (1,9), (1,10))
```

## randomSplit
Randomly splits this RDD with the provided weights. You can specify the fraction weights the output rdd's needs to split. However you can see they are not exactly equally split based on fraction as in example.

```
val inputRdd = sc.parallelize(1 to 10) 
val output = inputRdd.randomSplit(Array(0.5,0.5)) // return's array of rdd's   
output(0).collect() // rdd in 0th location 
res0: Array[Int] = Array(2, 5, 6, 8)  
output(1).collect() // rdd in 1st location 
res1: Array[Int] = Array(1, 3, 4, 7, 9, 10)
```

## reduce
Reduces the elements of this RDD. function in reduce obey's commutative and  associative properties.

```
val output = sc.parallelize(1 to 5).reduce((u,v) => u + v)
output: Int = 15 
```

## repartition
Return a new RDD that has exactly the passed argument partitions to this method.

```
val data = Seq(1, 2, 3, 4) 
val inputRdd = sc.parallelize(data,2) 
inputRdd.partitions; // Get the array of partitions of this RDD 
res2: Array[org.apache.spark.Partition] = Array(org.apache.spark.rdd.ParallelCollectionPartition@7b0, org.apache.spark.rdd.ParallelCollectionPartition@7b1) 
inputRdd.repartition(1) 
```

## sample
Return a sampled subset of this RDD.

```
val inputRdd = sc.parallelize(1 to 10, 3) 
inputRdd.sample(true, 0.3, 0).collect()   
  
Result: res0: Array[Int] = Array(1, 1, 4, 9) 
  
inputRdd.sample(false, 0.3, 0).collect() 
Result: res0: Array[Int] = Array(1, 4, 9) 
```

## sortBy
Return this RDD sorted by the given key function. You should pass function since its not pair rdd to generate key, boolean (asce/desc).

```
val output  = sc.parallelize(Array(3,4,2,1))
                .sortBy(x => x,false) // desc order by false
                .collect()
output: Array[Int] = Array(4, 3, 2, 1)
  
val output  = sc.parallelize(Array(3,4,2,1))
                .sortBy(x => x,true) // ascending order by true
                .collect()
output: Array[Int] = Array(4, 3, 2, 1)
output: Array[Int] = Array(1, 2, 3, 4) 
```

## subtract
Subtracts elements of one rdd from other

```
val output = sc.parallelize(1 to 10).subtract(sc.parallelize(5 to 15))
output.collect()
  
res0: Array[Int] = Array(2, 4, 1, 3)
```

## take
Take the first num elements of the RDD. It works by first scanning one partition, and use the results from that partition to estimate the number of additional partitions needed to satisfy the limit.

```
val output = sc.parallelize(1 to 10).take(2)
output: Array[Int] = Array(1, 2)
```

## takeSample
Return a fixed-size sampled subset of this RDD in an array.

sample | takeSample
-------|-----------
It returns an RDD | It returns an Array
Return a fixed-size sampled subset	| Return a fixed-size sampled subset
Should specify sample as Double fraction arg | sample is specified as Int

```

val inputRdd = sc.parallelize(1 to 10, 3) 
inputRdd.takeSample(true, 3, 0);   
  
res0: Array[Int] = Array(7, 6, 1)
```

## toLocalIterator
Return an iterator by converting RDD into a scala iterator that contains all of the elements in this RDD.

```
val output = sc.parallelize(1 to 5, 1).toLocalIterator
  
  while (output.hasNext) {
    println(output.next)
  }
1
2
3
4
5
```

## union
*Return the union of this RDD and another one.
*Identical elements will appear multiple times.
*Need to use distinct to eliminate them.
*Can also use ++ instead of union.

```
val a = sc.parallelize(1 to 10, 1)
val b = sc.parallelize(10 to 20, 1)
a.union(b).collect();
  
res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20) // 10 appeared 2 times since in 2 rdd.
  
a.union(b).distinct().collect();
res1: Array[Int] = Array(4, 16, 14, 6, 8, 20, 12, 18, 10, 2, 19, 13, 15, 11, 1, 17, 7, 3, 9, 5)
```
