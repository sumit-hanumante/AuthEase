package com.authease.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * Utility component for creating JSON Web Tokens used for authentication.
 */
@Component
public class JwtUtil {

    /** Signing key for the tokens (generated at startup). */
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /** Token validity in milliseconds. */
    private final long expirationMs = 30 * 60 * 1000; // 30 minutes

    /**
     * Generate a signed JWT token for the given username.
     *
     * @param username subject for the token
     * @return signed JWT string
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }
}
