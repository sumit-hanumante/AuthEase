package com.authease.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    /** In-memory user store keyed by username. */
    private final Map<String, User> users = new ConcurrentHashMap<>();

    /** Password encoder used to hash and verify passwords. */
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Register a new user if the username is not taken.
     *
     * @param username desired username
     * @param password plaintext password
     * @return {@code true} if registration succeeded, {@code false} when the user already exists
     */
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        String hashed = passwordEncoder.encode(password);
        users.put(username, new User(username, hashed));
        return true;
    }

    /**
     * Authenticate the user by validating the supplied credentials.
     *
     * @param username username to look up
     * @param password plaintext password to verify
     * @return a {@link User} object when credentials are valid; otherwise {@code null}
     */
    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }
}
