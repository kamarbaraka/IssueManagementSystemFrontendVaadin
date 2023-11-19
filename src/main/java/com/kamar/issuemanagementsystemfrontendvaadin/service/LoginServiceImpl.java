package com.kamar.issuemanagementsystemfrontendvaadin.service;

import com.kamar.issuemanagementsystemfrontendvaadin.proxy.LoginProxy;
import com.vaadin.flow.component.UI;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;
import java.util.Base64;

/**
 * implementation of the login service.
 * @author kamar baraka.*/

@Service
@Log4j2
public record LoginServiceImpl(
        LoginProxy loginProxy
) implements LoginService {
    @Override
    public void login(String username, String password) {

        /*construct credentials*/
        String usernamePassword = username + ":" + password;

        /*get the token*/
        String credentials = Base64.getEncoder().encodeToString(usernamePassword.getBytes());

        /*send the request*/
        ResponseEntity<Void> response = loginProxy.login(credentials);
        log.warn(response.getStatusCode().toString());

        if (!response.getStatusCode().equals(HttpStatus.OK)) {

            UI.getCurrent().navigate("login");
            return;
        }

        UI.getCurrent().navigate("dashboard");
    }
}
