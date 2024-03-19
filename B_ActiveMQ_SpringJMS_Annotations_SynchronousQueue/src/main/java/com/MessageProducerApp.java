package com;

import com.config.AppConfig;
import com.producer.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage("Message from Producer App");
        System.out.println("Message from Producer App");

        context.close();
    }
}
