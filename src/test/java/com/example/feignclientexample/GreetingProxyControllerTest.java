package com.example.feignclientexample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingProxyControllerTest {

    private static final MockWebServer mockWebServer = startMockWebServer();

    @Autowired
    private MockMvc mockMvc;

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("clients.greeting.url", () -> String.format("http://localhost:%s", mockWebServer.getPort()));
    }

    private static MockWebServer startMockWebServer() {
        MockWebServer server = new MockWebServer();
        try {
            server.start();
        }
        catch (IOException exception) {
            throw new IllegalStateException("Unable to start mock web server", exception);
        }
        return server;
    }

    @Test
    void shouldProxyGreetingResponseFromFeignClient() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody("{" +
                        "\"message\":\"Hello, Alice!\"" +
                        "}"));

        mockMvc.perform(get("/api/greetings/Alice"))
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "\"message\":\"Hello, Alice!\"" +
                        "}"));

        RecordedRequest recordedRequest = mockWebServer.takeRequest(1, TimeUnit.SECONDS);
        assertThat(recordedRequest).isNotNull();
        assertThat(recordedRequest.getMethod()).isEqualTo("GET");
        assertThat(recordedRequest.getPath()).isEqualTo("/api/external/greetings/Alice");
    }
}
