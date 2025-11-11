package com.MGolderPearl.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${microservices.product-microservcice-url}")
    private String productService;
    @Value("${microservices.user-microservcice-url}")
    private String userService;
    @Value("${microservices.order-microservcice-url}")
    private String orderService;
    @Value("${microservices.comment-microservcice-url}")
    private String commentService;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("product-service",
                        r -> r.path("/products/**")
                                .uri(productService))
                .route("categorie-service", r -> r.path("/categories/**").uri(productService))
                .route("user-service", r -> r.path("/users/**").uri(userService))
                .route("order-service", r -> r.path("/order/**").uri(orderService))
                .route("comment-service", r -> r.path("/comments/**").uri(commentService))
                .build();
    }
}
