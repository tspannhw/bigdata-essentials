package com.needforcode.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.*;

/**
 * Consumer Example for kafka
 */
public class ConsumerExample {

    private static Logger logger = LoggerFactory.getLogger(ProducerExample.class);

    private static String topic;

    public static void main(String[] args) {

        if (args.length != 1) {
            logger.error("pass the argument <topic_name>");
            System.exit(0);
        } else {
            topic = args[0];
        }

        Properties props = new Properties();
        props.put("zookeeper.connect", "localhost:2181");
        props.put("group.id", "11");
        props.put("zookeeper.session.timeout.ms", "500");
        props.put("zookeeper.sync.time.ms", "250");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");

        ConsumerConfig consumerConfig = new ConsumerConfig(props);

        ConsumerConnector consumer = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> map = new HashMap<>();

        map.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreamsMap =
                consumer.createMessageStreams(map);
        List<KafkaStream<byte[], byte[]>> streamList = consumerStreamsMap
                .get(topic);
        for (final KafkaStream<byte[], byte[]> stream : streamList) {
            ConsumerIterator<byte[], byte[]> consumerIterator = stream.iterator();
            while (consumerIterator.hasNext()) {
                logger.info("Messages from "+ topic + "Topic :: " + new String(consumerIterator.next().message()));
            }
        }
        if (consumer != null)
            consumer.shutdown();

    }

}
