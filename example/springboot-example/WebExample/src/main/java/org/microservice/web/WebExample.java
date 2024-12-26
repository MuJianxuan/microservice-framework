package org.microservice.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * web启动类
 * @author Rao
 * @Date 2024/12/26
 **/
@ComponentScan("org.microservice")
@SpringBootApplication
public class WebExample {
    public static void main(String[] args) {
        SpringApplication.run(WebExample.class, args);
    }
}
