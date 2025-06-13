# AuthEase

AuthEase is a small authentication service built with **Spring Boot**. It exposes simple username/password registration and login endpoints and supports social login using Google, Apple and GitHub via OAuth2.

The application stores users in memory for demonstration purposes. In a production deployment you should plug in a persistent database and properly secure the OAuth credentials.

## Features

- Register and login with a username and password
- Issue JWT access tokens
- OAuth2 login with Google, Apple and GitHub

## Requirements

- Java 17 or higher
- Maven 3+

## Building and Running

1. Build the project

```bash
mvn package
```

2. Run the generated jar

```bash
java -jar target/authease-0.0.1-SNAPSHOT.jar
```

The API will be available on `http://localhost:8080`.

### OAuth configuration

For social login you must provide OAuth client IDs and secrets. Set them as environment variables or in `application.properties` before starting the app. Example variables for Google:

```
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_SECRET
spring.security.oauth2.client.registration.google.scope=openid,email,profile
```

Replace `google` with `github` or `apple` for the other providers.

## Usage

### Register

`POST /auth/register`

```bash
curl -X POST http://localhost:8080/auth/register \
  -H 'Content-Type: application/json' \
  -d '{"username":"demo","password":"secret"}'
```

### Login

`POST /auth/login`

```bash
curl -X POST http://localhost:8080/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"demo","password":"secret"}'
```

Successful logins return a JSON body containing `access_token`.

### Social login

Initiate the flow by visiting one of

- `/oauth/google/login`
- `/oauth/apple/login`
- `/oauth/github/login`

On successful authentication a JWT token is returned.

## Notes

This service is for demonstration only and does not use persistent storage. OAuth credentials should be kept secure and never committed to version control.
