package org.microservice.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * desc: redis限流配置
 *
 * @author Rao
 * @Date 2021/11/06
 **/
@Configuration
public class RedisRateLimiterConfig {

    @Bean
    public KeyResolver ipKeyResolver(){
        return exchange -> Mono.just(Objects.requireNonNull( exchange.getRequest().getRemoteAddress()).getHostName());
    }

}
