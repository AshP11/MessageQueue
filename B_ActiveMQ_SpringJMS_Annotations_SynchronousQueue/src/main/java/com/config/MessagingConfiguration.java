package com.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import java.util.Arrays;

@Configuration
public class MessagingConfiguration {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String MESSAGE_QUEUE    = "message_queue";

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("com"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
//        template.setDefaultDestinationName(MESSAGE_QUEUE);
        return template;
    }

    @Bean
    MessageConverter converter() {
        return new SimpleMessageConverter();
    }
}
