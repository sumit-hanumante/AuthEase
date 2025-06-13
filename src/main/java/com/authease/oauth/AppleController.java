package com.authease.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Placeholder controller demonstrating Apple OAuth endpoints.
 */
@RestController
@RequestMapping("/oauth/apple")
public class AppleController {

    /**
     * Initiates the Apple OAuth login flow.
     *
     * @return message describing the endpoint
     */
    @GetMapping("/login")
    public Map<String, String> login() {
        return Map.of("message", "Apple OAuth login endpoint");
    }

    /**
     * Callback handler for Apple's OAuth redirect.
     *
     * @return placeholder response
     */
    @GetMapping("/callback")
    public Map<String, String> callback() {
        return Map.of("message", "Handle Apple OAuth callback");
    }
}
