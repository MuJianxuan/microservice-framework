package org.microservice.openfeign;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 暂不启用
 * @author Rao
 * @Date 2021/11/10
 **/
//@Configuration
public class CustomizedFeignConfiguration {

    @Bean
    @ConditionalOnMissingBean(Decoder.class)
    public Decoder feignDecoder(){
        return new CustomizedFeignResultDecoder();
    }

    /**
     *
     * 定制的结果解析器 是否需要继承 相关的 Gzip解码器呢？
     */
    static class CustomizedFeignResultDecoder implements Decoder {

        @Override
        public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
            return null;
        }
    }


}
