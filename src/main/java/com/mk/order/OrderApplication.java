package com.mk.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Value("${services.product.url}")
    private String productServiceUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(productServiceUrl).build();
    }
}
