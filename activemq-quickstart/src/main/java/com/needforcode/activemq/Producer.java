package com.needforcode.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {

    public static void main(String[] args) throws Exception {

        try{

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory
                ("tcp://localhost:61616");

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("QUEUE_NAME");

            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            producer.send(session.createTextMessage("Test Message"));

            session.close();
            connection.close();

        } catch(JMSException e) {
            e.printStackTrace();
            throw new JMSException("jms exception");
        }
    }
}
