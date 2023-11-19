package com.kamar.issuemanagementsystemfrontendvaadin.config;

import com.kamar.issuemanagementsystemfrontendvaadin.app_properties.AppServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * the configuration properties.
 * @author kamar baraka.*/

@Configuration
@EnableConfigurationProperties(value = {
        AppServerProperties.class
})
public class ConfigurationProperties {
}
