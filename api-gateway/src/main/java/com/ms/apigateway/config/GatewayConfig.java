package com.ms.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // User Service Route
                .route("user-service-route", r -> r
                        .path("/users/**") // Predicate: Matches /users/...
                        .filters(f -> f
                                .stripPrefix(1) // Filter: Removes /users
                                .addRequestHeader("X-Gateway", "SpringCloudGateway")) 
                        .uri("lb://USER-SERVICE")) // Target: Eureka Service ID

                // Department Service Route
                .route("department-service-route", r -> r
                        .path("/departments/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://DEPARTMENT-SERVICE"))
                
                .build();
    }
}
