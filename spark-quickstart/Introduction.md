

## Architecture overview

- Driver Program
- Cluster Manager
- Executors
- Workers

![cluster-overview](https://cloud.githubusercontent.com/assets/8268939/20009389/b4603934-a27a-11e6-9240-faaeff2b4d56.png)

&copy; spark.apache.org

In Driver Program you will create spark context, convert user program into tasks. When you submit jobs using spark-submit or pyspark, the request will go to cluster manager and cluster manager will talk to worker nodes and create executors. Then spark context will talk directly to exectors and get the reports of the job.

## Cluster Modes

The default mode will be local.

- Local Mode: used when you install spark in your laptop.
- YARN : used mostly when you use spark with other hadoop frameworks.
- Mesos: used when you are not using other dependent frameworks of Hadoop ecosystem.
- Standalone: you simply place a compiled version of Spark on each node on the cluster to install it. Uses standalone scheduler.

## Modules in spark

- Spark core
- DataFrames & Data sets
- Spark Streaming
- MLIB
- GraphX

## RDD Basics

- immutable distribtued collection of objects.
- Each RDD is split into mutliple partitions and can contain any objects inside it.
- Created by loading any dataset from hdfs, local or s3 filesystems or using collection of objects in driver program.
- Transformations and Actions can be executed on top of RDD
	- Transformations will give a new RDD from previous one.
	- Actions compute result and return to driver or save it in filesystems.

## Persistence

When you call action, spark will recompute RDD's from beginning and its an expensive process if you use same RDD for different computations.
To avoid computing RDD multiple times, you can use persist(). unpersist() is used to unpersist a persisted RDD.

Persistent levels in spark
- MEMORY_ONLY
- MEMORY_ONLY_SER
- MEMORY_AND_DISK
- MEMORY_AND_DISK_SER
- DISK_ONLY

If you try to cache too much data than spark can hold, it will use LRU (least recently used) algorithm and evacuate old partitions.


## Spark SQL

- Can read from Tableau
- Can connect and execute sql from JDBC/ODBC apps
- Can run from your spark application
- Can run from spark sql shell

