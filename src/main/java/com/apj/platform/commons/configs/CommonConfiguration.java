package com.apj.platform.commons.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class CommonConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
