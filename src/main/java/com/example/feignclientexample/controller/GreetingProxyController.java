package com.example.feignclientexample.controller;

import com.example.feignclientexample.client.GreetingClient;
import com.example.feignclientexample.model.GreetingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingProxyController {

    private final GreetingClient greetingClient;

    public GreetingProxyController(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    @GetMapping("/api/greetings/{name}")
    public GreetingResponse getGreeting(@PathVariable String name) {
        return greetingClient.getGreeting(name);
    }
}
