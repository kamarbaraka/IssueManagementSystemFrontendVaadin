package com.kamar.issuemanagementsystemfrontendvaadin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * the proxy configuration.
 * @author kamar baraka.*/

@Configuration
public class ProxyConfig {

    @Bean
    public RestTemplate restTemplate(){

        /*return an instance of rest template*/
        return new RestTemplate();
    }
}
