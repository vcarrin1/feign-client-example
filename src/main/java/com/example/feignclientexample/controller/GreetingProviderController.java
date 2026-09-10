package com.example.feignclientexample.controller;

import com.example.feignclientexample.model.GreetingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingProviderController {

    @GetMapping("/api/external/greetings/{name}")
    public GreetingResponse getGreeting(@PathVariable String name) {
        return new GreetingResponse("Hello, " + name + "!");
    }
}
