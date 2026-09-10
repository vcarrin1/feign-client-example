# feign-client-example
Project example using Feign Client instead of Rest Template

## Implementation details

- Enable Feign support in the Spring Boot application configuration.
- Define a Feign client interface for the downstream API, including the target base URL and endpoint mappings.
- Inject the Feign client into the service layer so outbound HTTP calls are handled through the interface rather than `RestTemplate`.
- Keep request and response payloads in dedicated DTOs to separate transport concerns from business logic.
- Externalize the remote service configuration through application properties so environments can override endpoints without code changes.
