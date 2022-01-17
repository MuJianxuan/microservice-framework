package org.microservice.web.config;

import org.microservice.core.config.YamlConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 *
 * @author Rao
 * @Date 2021/11/10
 **/
@Configuration
@ConfigurationProperties(prefix = "frame.web")
@Getter
@Setter
public class WebYamlConfiguration implements YamlConfiguration {

    /**
     * web 是跨域的
     */
    private Boolean isCors = false;


}
