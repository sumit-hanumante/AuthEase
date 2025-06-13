package com.authease.auth;

import com.authease.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST controller exposing authentication endpoints.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    /** Service handling user persistence and verification. */
    private final UserService userService;

    /** Utility for generating JWT tokens. */
    private final JwtUtil jwtUtil;

    /**
     * Create a new controller with the required dependencies.
     */
    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    /**
     * Create a new user account.
     *
     * @param body JSON payload containing {@code username} and {@code password}
     * @return HTTP 200 when registration succeeds, 400 if the user already exists
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        if (!userService.register(username, password)) {
            return ResponseEntity.badRequest().body(Map.of("error", "User already exists"));
        }
        return ResponseEntity.ok(Map.of("message", "User registered"));
    }

    /**
     * Authenticate a user with username and password.
     *
     * @param body JSON payload containing credentials
     * @return an access token when credentials are valid; 401 otherwise
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        User user = userService.authenticate(username, password);
        if (user == null) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(Map.of("access_token", token));
    }
}
