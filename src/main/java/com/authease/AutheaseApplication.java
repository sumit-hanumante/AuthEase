package com.authease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the AuthEase Spring Boot application.
 * <p>
 * Bootstraps the Spring context and starts the embedded server.
 */
@SpringBootApplication
public class AutheaseApplication {

    /**
     * Application main method.
     *
     * @param args command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(AutheaseApplication.class, args);
    }
}
