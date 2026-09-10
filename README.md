# feign-client-example

Java and Spring Boot example showing how to use OpenFeign instead of `RestTemplate`.

## What it does

- Starts a Spring Boot application
- Uses a Feign client to call a remote `/todos/{id}` endpoint
- Exposes `/api/todos/{id}` as a simple proxy endpoint

By default, the Feign client points to `https://jsonplaceholder.typicode.com`.

## Run the application

```bash
mvn spring-boot:run
```

Then call:

```bash
curl http://localhost:8080/api/todos/1
```

## Override the Feign target

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--example.todo.base-url=http://localhost:9090
```

## Run tests

```bash
mvn test
```
