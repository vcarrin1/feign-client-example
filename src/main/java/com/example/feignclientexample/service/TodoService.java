package com.example.feignclientexample.service;

import com.example.feignclientexample.client.JsonPlaceholderClient;
import com.example.feignclientexample.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public TodoService(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    public Todo getTodo(int id) {
        return jsonPlaceholderClient.getTodo(id);
    }
}
