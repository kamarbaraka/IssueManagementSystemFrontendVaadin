package com.kamar.issuemanagementsystemfrontendvaadin.proxy;

import com.kamar.issuemanagementsystemfrontendvaadin.app_properties.AppServerProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * implementation of the login proxy.
 * @author kamar baraka.*/

@Service
public record LoginProxyImpl(
        RestTemplate restTemplate,
        AppServerProperties appServerProperties
) implements LoginProxy {
    @Override
    public ResponseEntity<Void> login(String token) {

        String url = appServerProperties.host() + ":" + appServerProperties().port() + "/api/v1/login";

        /*set the headers*/
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(token);

        /*create the request entity*/
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        /*set the request*/
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, Void.class);

    }
}
