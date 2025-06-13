package com.authease.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Placeholder controller demonstrating GitHub OAuth endpoints.
 */
@RestController
@RequestMapping("/oauth/github")
public class GithubController {

    /**
     * Initiates the GitHub OAuth process.
     *
     * @return message describing the endpoint
     */
    @GetMapping("/login")
    public Map<String, String> login() {
        return Map.of("message", "GitHub OAuth login endpoint");
    }

    /**
     * Callback handler once GitHub has authenticated the user.
     *
     * @return placeholder response
     */
    @GetMapping("/callback")
    public Map<String, String> callback() {
        return Map.of("message", "Handle GitHub OAuth callback");
    }
}
