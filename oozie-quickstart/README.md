## oozie examples

NOTE: This example is executed in hortonworks sandbox.

#### Oozie cheat sheet

- To check the version of oozie.
```bash
oozie admin -version
Result: Oozie server build version: 4.1.0.2.2.4.2-2
```

- To view oozie web console
```bash
http://<OOZIE_HOST>:11000/oozie/

Example: http://localhost:11000/oozie/
```

- To check health of oozie.
```bash
oozie admin -oozie http://localhost:11000/oozie -status
Result: System mode: NORMAL
```

- To view oozie share lib jars
```bash
hadoop fs -ls /user/oozie/share/lib
```

- To start an oozie job
```bash
oozie job -config job.properties -run
```

- To view the status of job
```bash
oozie job -info <oozie_job_id>
```

- To kill the oozie job/coordinator job.
```bash
oozie job -kill <job_id>
```

#### Workflow example

Let us develop and execute simple workflow.

- For running a workflow we need following files.
	- [workflow.xml](https://github.com/vasu-d/bigdata-essentials/blob/master/oozie-quickstart/src/main/oozie/workflow/workflow.xml) (xml file consists of oozie actions)
	- [job.properties](https://github.com/vasu-d/bigdata-essentials/blob/master/oozie-quickstart/src/main/oozie/workflow/job.properties) (key,value parameters required for oozie job)

- We need to set oozie system lib path in job.properties to add requisite jars files in oozie classpath.
```bash
oozie.libpath=${nameNode}/user/oozie/share/lib/lib_20150424130956
oozie.use.system.libpath=true
```

- we need to add nameNode and JobTracker/ResourceMngr to job.properties which resolves and let oozie know about them.
```bash
nameNode=hdfs://sandbox:8020
jobTracker=sandbox:8050
queueName=default
```

- Copy the workflow.xml (in src/main/oozie/workflow) and script.hql(in resouces) to hdfs.
```bash
hadoop fs -put workflow.xml /oozie-hive/
hadoop fs -put script.hql /oozie-hive/
```

- Have the job.property in local and run the following command.
```bash
export OOZIE_URL=http://sandbox:11000/oozie
oozie job -config job.properties -run
```
 
#### coordinator example

1. Create the hadoop directories to place workflow and coordinator xml files.

	```bash
	hadoop fs -mkdir hdfs://sandbox:8020/oozie-hive

	hadoop fs -mkdir hdfs://sandbox:8020/oozie-hive-coord
	```

2. Copy the xml files from oozie-quickstart/src/main/oozie/coordinator to HDFS and hive-site.xml from edge node of cluster, script.hql from resources of project.

	```bash
	hadoop fs -put workflow.xml hdfs://sandbox:8020/oozie-hive

	hadoop fs -put coordinator.xml hdfs://sandbox:8020/oozie-hive-coord

	hadoop fs -put /etc/hive/conf/hive-site.xml /oozie-hive/

	hadoop fs -put script.hql /oozie-hive/
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



