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
@RequestMapping("/oauth/github")
public class GithubController {

    /**
     * Initiates the GitHub OAuth process.
     *
     * @return message describing the endpoint
     */
    @GetMapping("/login")
    public RedirectView login() {
        return new RedirectView("/oauth2/authorization/github");
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
