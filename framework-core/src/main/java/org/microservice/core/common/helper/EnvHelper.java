package org.microservice.core.common.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 服务环境助手
 * @author Rao
 * @Date 2021/11/08
 **/
@Component
public class EnvHelper {

    @Value("spring.profiles.active")
    private String env;


    /**
     * 开发环境
     * @return
     */
    public boolean isDev(){
        return env == null || "dev".equals( env);
    }

    /**
     * 正式环境
     * @return
     */
    public boolean isProd(){
        return "prod".equals( env);
    }

}
