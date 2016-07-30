## oozie examples

NOTE: This example is executed in hortonworks sandbox.

#### coordinator example

1. Create the hadoop directories to place workflow and coordinator xml files.

	```bash
	hadoop fs -mkdir hdfs://sandbox:8020/oozie-hive

	hadoop fs -mkdir hdfs://sandbox:8020/oozie-hive-coord
	```

2. Copy the xml files from oozie-quickstart/src/main/oozie/coordinator to above directories.

	```bash
	hadoop fs -put workflow.xml hdfs://sandbox:8020/oozie-hive

	hadoop fs -put coordinator.xml hdfs://sandbox:8020/oozie-hive-coord
	```

3. Export OOZIE_URL
	```bash
	export OOZIE_URL=http://sandbox:11000/oozie
	```

4. Submit the coordinator job
	```bash
	oozie job -run -config coord.properties
	job: 0000000-160730023855324-oozie-oozi-C
	```

5. Copy the <job_id> above and execute following command to see job status.
	```bash
	oozie job -oozie http://sandbox:11000/oozie -info 0000000-160730023855324-oozie-oozi-C
	```

6. List all coordinator jobs
	```bash
	oozie jobs -jobtype coord
	```

7. To kill any coordinator job
	```bash
	oozie job -kill <coord_id>
	```



