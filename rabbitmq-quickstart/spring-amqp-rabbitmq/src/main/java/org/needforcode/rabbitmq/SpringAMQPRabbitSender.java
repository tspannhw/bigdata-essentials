package org.needforcode.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAMQPRabbitSender {

    private static final String SENDER_XML = "springamqp-rabbit-sender-context.xml";

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext(SENDER_XML);
        AmqpTemplate amqpTemplate = (AmqpTemplate) context.getBean("amqpTemplate");

        int messagCount = 0;
        while (messagCount < 10){
            amqpTemplate.convertAndSend("tp.routingkey.1", "Message # " + messagCount++);
        }
        System.out.println( messagCount + " message(s) sent successfully.");
    }
}
