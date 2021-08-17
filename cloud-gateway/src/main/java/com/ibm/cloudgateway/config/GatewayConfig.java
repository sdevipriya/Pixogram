package com.ibm.cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.socket.client.WebSocketClient;

@Configuration
public class GatewayConfig {
	
	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}

	
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(r-> r.path("/products/**")
//                        .uri("http://localhost:8081/"))
//                .route(r-> r.path("/orders/**")
//                        .uri("http://localhost:8082"))
//                .build();
//    }
}
