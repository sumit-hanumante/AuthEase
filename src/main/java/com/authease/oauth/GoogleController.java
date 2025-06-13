package com.authease.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Placeholder controller demonstrating Google OAuth endpoints.
 */
@RestController
@RequestMapping("/oauth/google")
public class GoogleController {

    /**
     * Initiates the Google OAuth flow.
     *
     * @return simple message indicating the endpoint
     */
    @GetMapping("/login")
    public Map<String, String> login() {
        return Map.of("message", "Google OAuth login endpoint");
    }

    /**
     * Callback handler once Google has authenticated the user.
     *
     * @return placeholder response
     */
    @GetMapping("/callback")
    public Map<String, String> callback() {
        return Map.of("message", "Handle Google OAuth callback");
    }
}
