package org.microservice.web.mvc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Rao
 * @Date 2021/11/10
 **/
@ConditionalOnProperty(prefix = "frame.web",name = "is-cors",havingValue = "true",matchIfMissing = true)
@Component
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*");
                //跨域允许时间  默认是 30分钟
//                .maxAge(3600);
    }
}
