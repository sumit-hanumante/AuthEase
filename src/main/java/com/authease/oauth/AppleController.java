package com.authease.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller redirecting to the actual Spring Security OAuth2 login path.
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
    public RedirectView login() {
        return new RedirectView("/oauth2/authorization/apple");
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
