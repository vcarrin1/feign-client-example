package com.example.feignclientexample.model;

public record Todo(Integer userId, Integer id, String title, Boolean completed) {
}
