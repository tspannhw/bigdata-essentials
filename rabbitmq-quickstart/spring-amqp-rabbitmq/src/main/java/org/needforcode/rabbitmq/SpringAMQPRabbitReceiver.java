package org.needforcode.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/*
Spring AMQP Rabbit Aync Receiver
 */
public class SpringAMQPRabbitReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("Listener received message = " + new String(message.getBody()));
    }
}
