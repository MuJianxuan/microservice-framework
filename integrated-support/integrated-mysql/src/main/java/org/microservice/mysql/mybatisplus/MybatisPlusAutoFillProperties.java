package org.microservice.mysql.mybatisplus;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rao
 * @Date 2021/11/08
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "frame.mybatisplus.autofill")
@RefreshScope
@Configuration
public class MybatisPlusAutoFillProperties {

    private Boolean enable = true;

    private Boolean enableCreateDateFill = true;

    private Boolean enableUpdateDateFill = true;

    private String createTimeFill = "createTime";

    private String updateTimeFill = "updateTime";

}
