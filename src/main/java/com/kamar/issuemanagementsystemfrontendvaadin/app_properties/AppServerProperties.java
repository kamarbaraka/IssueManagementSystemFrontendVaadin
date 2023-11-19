package com.kamar.issuemanagementsystemfrontendvaadin.app_properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * the app server properties.
 * @author kamar baraka.*/

@ConfigurationProperties("app.server")
public record AppServerProperties(

        String host,
        int port
) {
}
