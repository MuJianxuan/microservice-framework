package org.microservice.web.config;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

/**
 * @author Rao
 * @Date 2024/12/26
 **/
@Configuration
public class UndertowConfiguration implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            deploymentInfo.setExecutor(Executors.newThreadPerTaskExecutor(Thread.ofVirtual().name("undertow-virtual-thread",1).factory()));
        });
    }
}
