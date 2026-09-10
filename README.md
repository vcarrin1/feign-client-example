# feign-client-example

Simple Spring Boot project that uses a Feign Client to work with a REST API.

## What it does

- exposes `/api/external/greetings/{name}` as a sample REST API
- uses a Feign client to call that API
- exposes `/api/greetings/{name}` as the proxied endpoint

## Run the project

```bash
mvn spring-boot:run
```

Then call the Feign-backed endpoint:

```bash
curl http://localhost:8080/api/greetings/Alice
```

Expected response:

```json
{"message":"Hello, Alice!"}
```

## Test the project

```bash
mvn test
```
