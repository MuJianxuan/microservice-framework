package org.microservice.redis.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2020/8/6
 **/
@ConditionalOnBean(value = RedisProperties.class)
@Configuration
public class GlobalRedisConfig {


    /**
     * 配置Redis的序列化
     * @param lettuceConnectionFactory
     * @return
     */
    @Bean
    @Resource
    @ConditionalOnBean(value = LettuceConnectionFactory.class)
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory){

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();

        //设置工厂
        redisTemplate.setConnectionFactory( lettuceConnectionFactory);
        //主要是设置key和value的序列化
        redisTemplate.setKeySerializer( keySerializer());
        redisTemplate.setValueSerializer( valueSerializer());

        redisTemplate.setHashKeySerializer( keySerializer());
        redisTemplate.setHashValueSerializer( valueSerializer());

        /*必须执行这个函数,初始化RedisTemplate*/
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**键序列化**/
    private StringRedisSerializer keySerializer(){
        return new StringRedisSerializer();
    }

    private FastJsonRedisSerializer<Object> valueSerializer(){
        return new FastJsonRedisSerializer<>(Object.class);
    }




}
