package com.needforcode.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    public static void main(String[] args) throws Exception {

        try {

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory
                ("tcp://localhost:61616");

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("QUEUE_NAME");

            MessageConsumer producer = session.createConsumer(destination);

            Message message = producer.receive(1000);

            if(message instanceof TextMessage) {
                System.out.println(((TextMessage) message).getText());
            } else {
                System.out.println(message);
            }

            session.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
