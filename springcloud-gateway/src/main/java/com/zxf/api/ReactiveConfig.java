package com.zxf.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author zxf
 * 限流配置
 */
@Configuration
public class ReactiveConfig {

    /**
     * 基于用户限流
     * @return
     */
//    @Bean
//    public KeyResolver userKeyResolver(){
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
//    }

    /**
     * 基于ip限流
     * @return
     */
    @Bean
    public KeyResolver ipKeyResolver(){
        KeyResolver keyResolver = exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
        return keyResolver;
    }

}
