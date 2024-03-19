package com;

import com.config.AppConfig;
import com.model.Product;
import com.producer.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage("Message from Producer App");
        System.out.println("Message from Producer App");

        Product product = new Product();
        product.setProductId(100);
        product.setName("Fortuner");
        product.setQuantity(50);
        messageSender.sendProductData(product);
        System.out.println("Product data from Producer App");
        context.close();
    }
}
