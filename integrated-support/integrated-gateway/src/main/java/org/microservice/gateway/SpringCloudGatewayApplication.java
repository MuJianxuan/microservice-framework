package org.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Rao
 * @Date 2021/11/06
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringCloudGatewayApplication.class,args);
    }

}
