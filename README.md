# feign-client-example

Simple Spring Boot project that uses a Feign client to work with a REST API and secures the API with Auth0-backed JWT validation.

Requires Java 25.

## Requirements

- Java 25
- Maven

## What it does

- exposes `/api/external/greetings/{name}` as a sample REST API
- uses a Feign client to call that API
- exposes `/api/greetings/{name}` as the proxied endpoint
- secures GET endpoints with `SCOPE_USER` or `SCOPE_ADMIN`

## Auth0 configuration

Set these environment variables before starting the app if you want to override the sample Auth0 settings:

```bash
export AUTH0_ISSUER_URI=https://your-tenant.us.auth0.com/
export AUTH0_AUDIENCE=your-api-identifier
```

## Run the project

```bash
mvn spring-boot:run
```

Then call the Feign-backed endpoint with a bearer token:

```bash
curl http://localhost:8080/api/greetings/Alice \
  -H "Authorization: ******"
```

Expected response:

```json
{"message":"Hello, Alice!"}
```

## Test the project

```bash
mvn test
```
