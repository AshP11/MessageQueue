package com;

import com.config.AppConfig;
import com.receiver.MessageReceiver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageConsumerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageReceiver messageReceiver = context.getBean(MessageReceiver.class);
        String response = messageReceiver.receiveMessage();
        System.out.println("Message received- " + response);

        context.close();
    }
}
