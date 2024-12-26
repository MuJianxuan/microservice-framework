package org.microservice.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * desc: 网关服务入口
 *
 * @author Rao
 * @Date 2022/02/13
 **/
@SpringBootApplication(scanBasePackages = {"org.microservice"})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run( GatewayApplication.class,args );
    }

}
