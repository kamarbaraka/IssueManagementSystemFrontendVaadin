package com.kamar.issuemanagementsystemfrontendvaadin.proxy;

import org.springframework.http.ResponseEntity;

/**
 * the login proxy.
 * @author kamar baraka.*/

public interface LoginProxy {

    ResponseEntity<Void> login(String token);
}
