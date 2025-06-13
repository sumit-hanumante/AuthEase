package com.authease.auth;

/**
 * Simple user record storing username and a hashed password.
 */
public class User {
    /** The unique username for the user. */
    private String username;

    /**
     * BCrypt hashed password for the user.
     */
    private String passwordHash;

    /**
     * Construct a new user instance.
     *
     * @param username     chosen username
     * @param passwordHash BCrypt hash of the user's password
     */
    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    /**
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return stored BCrypt password hash
     */
    public String getPasswordHash() {
        return passwordHash;
    }
}
