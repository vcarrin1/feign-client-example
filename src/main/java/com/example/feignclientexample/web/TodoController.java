package com.example.feignclientexample.web;

import com.example.feignclientexample.model.Todo;
import com.example.feignclientexample.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable int id) {
        return todoService.getTodo(id);
    }
}
