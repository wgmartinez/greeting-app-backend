package com.equifax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication(scanBasePackages = {"com.equifax.ren", "com.equifax"})
@EnableResourceServer
public class GreetApplicationBackend {

    public static void main(String[] args) {

        SpringApplication.run(GreetApplicationBackend.class, args);
    }
}
