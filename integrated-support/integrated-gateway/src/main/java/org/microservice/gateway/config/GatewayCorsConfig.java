package org.microservice.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

/**
 * 还可以 yaml 配置
 * @author Rao
 * @Date 2021/11/06
 **/
@Configuration
public class GatewayCorsConfig {

    private static final String ALL = "*";
    private static final String MAX_AGE = "18000L";

    /**
     * 跨域过滤器
     * @return
     */
    @Bean
    public WebFilter corsFilter(){
        return ((serverWebExchange, webFilterChain) -> {
            ServerHttpRequest serverHttpRequest = serverWebExchange.getRequest();
            if (! CorsUtils.isCorsRequest( serverHttpRequest)) {
                return webFilterChain.filter( serverWebExchange);
            }

            HttpHeaders requestHeaders = serverHttpRequest.getHeaders();
            HttpMethod accessControlRequestMethod = requestHeaders.getAccessControlRequestMethod();

            ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
            HttpHeaders responseHeaders = serverHttpResponse.getHeaders();


            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
            responseHeaders.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());
            if (accessControlRequestMethod != null) {
                responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, accessControlRequestMethod.name());
            }
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ALL);
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
            if (serverHttpRequest.getMethod() == HttpMethod.OPTIONS) {
                serverHttpResponse.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }

            return webFilterChain.filter(serverWebExchange);
        });
    }

}
