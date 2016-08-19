package org.needforcode.rabbitmq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAMQPRabbitlReceiverContainer {

    public static void main(String[] args) {
        // Initialize Spring IOC Container (or) Load the listener container
        new ClassPathXmlApplicationContext("springamqp-rabbt-receiver-context.xml");
    }
}
