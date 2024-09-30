package com.example.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator route(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder.routes().route(p->p.path("/currency-conversion-feign/**")
                .uri("lb://currency-conversion-service")).build();
    }
}
