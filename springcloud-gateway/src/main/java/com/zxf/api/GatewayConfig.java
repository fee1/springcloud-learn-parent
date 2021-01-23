package com.zxf.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator targetRouteLocator(RouteLocatorBuilder builder){
//        return builder
//                .routes().route("target", r -> r.path("/getRibbon/**", "/success/**")
//                .uri("http://localhost:11000")).
//                build();
//    }

}
