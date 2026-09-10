package com.example.feignclientexample.client;

import com.example.feignclientexample.model.GreetingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "greetingClient", url = "${clients.greeting.url:http://localhost:8080}")
public interface GreetingClient {

    @GetMapping("/api/external/greetings/{name}")
    GreetingResponse getGreeting(@PathVariable("name") String name);
}
