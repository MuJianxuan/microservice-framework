package org.microservice.example.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Rao
 * @Date 2023/3/24
 **/
@SpringBootApplication
public class RabbitmqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run( RabbitmqProducerApplication.class, args);
    }
}

