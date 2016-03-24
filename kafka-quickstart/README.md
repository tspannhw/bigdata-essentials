# kafka-quickstart

you need to have Java & Maven installed

# package the jar

  1) git clone

  2) mvn clean package

# Build requirements

Oracle JDK for Java 7 & Scala 2.11-0.

# Kafka installation (mac)

```
  1) Download kafka
     curl -O http://www.trieuvan.com/apache/kafka/0.9.0.0/kafka_2.11-0.9.0.0.tgz

  2) untar the tar file downloaded
     tar xf kafka_2.11-0.9.0.0.tgz

  3) cd kafka_2.11-0.9.0.0.tgz
   ```

# start services

```
  1) start zookeeper server
     bin/zookeeper-server-start.sh config/zookeeper.properties

  2) start the kafka server
     bin/kafka-server-start.sh config/server.properties
```

# quick start using cli commands

```
  1) create a topic 
     bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic sv

  2) list the topics
     bin/kafka-topics.sh --list --zookeeper localhost:2181

  3) send some messages to the topic. enter below command and start typing on the screen
     bin/kafka-console-producer.sh --broker-list localhost:9092 --topic sv

  4) read messages from topic
     bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic sv --from-beginning
     ```

# run producer java code

```
java -cp kafka-quickstart-1.0-SNAPSHOT.jar com.bigdataguide.kafka.ProducerExample sv
```

# run consumer java code

```
java -cp kafka-quickstart-1.0-SNAPSHOT.jar com.bigdataguide.kafka.ConsumerExample sv
```
