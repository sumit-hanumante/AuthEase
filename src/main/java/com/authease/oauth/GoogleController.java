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
@RequestMapping("/oauth/google")
public class GoogleController {

    /**
     * Initiates the Google OAuth flow.
     *
     * @return simple message indicating the endpoint
     */
    @GetMapping("/login")
    public RedirectView login() {
        return new RedirectView("/oauth2/authorization/google");
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
