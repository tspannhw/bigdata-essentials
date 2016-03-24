package com.bigdataguide.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * ProducerExample for kafka producer
 */
public class ProducerExample {

    private static Logger logger = LoggerFactory.getLogger(ProducerExample.class);
    private static String topic = "";

    public static void main(String[] args) {

        if (args.length != 1) {
            logger.error("pass the argument <topic_name>");
            System.exit(0);
        }

        topic = args[0];

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("request.required.acks", "1");

        KafkaProducer<String, String> producer = new KafkaProducer(props);

        try {
            int i = 0;
            while (i < 5) {
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, "message" + i);
                producer.send(record);
                logger.info("sending record: " + record);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            producer.close();
        }

    }
}
