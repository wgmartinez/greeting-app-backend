package com.equifax.service;

import org.springframework.http.ResponseEntity;

public interface GreetingService {
    ResponseEntity<String> greet(String country, String name);
}
