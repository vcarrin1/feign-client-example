package com.example.feignclientexample.client;

import com.example.feignclientexample.model.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "jsonPlaceholderClient",
        url = "${example.todo.base-url:https://jsonplaceholder.typicode.com}"
)
public interface JsonPlaceholderClient {

    @GetMapping("/todos/{id}")
    Todo getTodo(@PathVariable int id);
}
