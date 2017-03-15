# mapreduce_templates

# Packaging
```
git clone https://github.com/skillvoice/mapreduce_templates.git
cd mapreduce_templates
mvn clean install
```

# Running Commands

Usage: Usage: hadoop jar <jar> [mainClass] args...

```
WordCount: hadoop jar mapreduce_templates-1.0-SNAPSHOT.jar WordCount <input_dir> <output_dir>
```

```
MapJoin: hadoop jar mapreduce_templates-1.0-SNAPSHOT.jar MapJoinDriver <person_file_hdfs_path> <path_to_cache_file_hdfs>/person_diagnosis.csv <output_path>
```

```
ReduceJoin: hadoop jar mapreduce_templates-1.0-SNAPSHOT.jar ReduceJoinDriver <person_file_hdfs_path> <persondiagnosis_hdfs_path> <output_path>
```

```
Combiner: hadoop jar mapreduce_templates-1.0-SNAPSHOT.jar com.needforcode.mapreduce.combiner.CombinerDriver <person_file_hdfs_path> <output_path>
```

```
Partitioner: hadoop jar mapreduce_templates-1.0-SNAPSHOT.jar PartitionerDriver <person_file_hdfs_path> <output_path>
```

