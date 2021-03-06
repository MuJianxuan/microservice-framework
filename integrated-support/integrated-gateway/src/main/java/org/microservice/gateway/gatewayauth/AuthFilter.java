package org.microservice.gateway.gatewayauth;

import org.microservice.gateway.constant.GatewayConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Rao
 * @Date 2021/11/06
 **/
@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("has one request in.................{} ",exchange.getRequest().getPath() );
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GatewayConstants.GATEWAY_AUTH_FILTER_ORDER;
    }
}
