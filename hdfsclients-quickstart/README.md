# hdfsclients-quickstart

Examples of HDFS client in various API

# Build a Jar

```
git clone https://github.com/needforcode/bigdata-essentials.git

cd bigdata-essentials/hdfsclients-quickstart

mvn clean install
```

# Running Commands
```
hadoop jar hdfsclients-quickstart-1.0-SNAPSHOT.jar com.needforcode.hdfsclients.HDFSClient mkdir dirname

hadoop jar hdfsclients-quickstart-1.0-SNAPSHOT.jar com.needforcode.hdfsclients.HDFSClient rename dirname dirname1

hadoop jar hdfsclients-quickstart-1.0-SNAPSHOT.jar com.needforcode.hdfsclients.HDFSClient delete dirname1
```
