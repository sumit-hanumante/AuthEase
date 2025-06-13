# AuthEase

AuthEase is a simple authentication and authorization service built with **Spring Boot**. It demonstrates username/password registration and login and includes placeholder endpoints for Google, Apple and GitHub OAuth flows.

The service keeps data in memory for demonstration purposes. In a real deployment you would integrate a database and replace the OAuth placeholders with proper flows.

## Features

- Register and login with a username and password
- JWT based access tokens
- Placeholder routes for Google, Apple and GitHub OAuth

## Requirements

- Java 17+
- Maven 3+

## Building and Running

Follow these steps to build and start the service locally.

1. Build the project using Maven:

```bash
mvn package
```

2. Run the generated jar:

```bash
java -jar target/authease-0.0.1-SNAPSHOT.jar
```

The API will start on `http://localhost:8080` by default.

You can then interact with the endpoints using `curl` or any HTTP client.
For example to register a user:

```bash
curl -X POST http://localhost:8080/auth/register \
  -H 'Content-Type: application/json' \
  -d '{"username":"demo","password":"secret"}'
```

And to log in and receive a token:

```bash
curl -X POST http://localhost:8080/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"demo","password":"secret"}'
```

## API Endpoints

### Register

`POST /auth/register`

Example body:

```json
{
  "username": "user1",
  "password": "strong-password"
}
```

### Login

`POST /auth/login`

Example body:

```json
{
  "username": "user1",
  "password": "strong-password"
}
```

Successful responses include an `access_token`.

### Social OAuth (placeholders)

- `GET /oauth/google/login`
- `GET /oauth/apple/login`
- `GET /oauth/github/login`

Each provider exposes a corresponding `/callback` endpoint.

The OAuth routes are placeholders and simply return a message. Replace them with
real integrations if you need social logins in your deployment.

## Notes

This example stores users in memory and is not meant for production. Add persistent storage and real OAuth integrations before deploying.
