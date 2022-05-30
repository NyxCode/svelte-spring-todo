package com.example.todobackend.controller;

import com.example.todobackend.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/todos")
    List<Todo> all() {
        return Todo.all();
    }

    @DeleteMapping("/todos/{id}")
    void delete(@PathVariable int id) {
        Todo.byId(id).delete();
    }

    @PostMapping("/todos")
    Todo create(@RequestBody String content) {
        return new Todo(content);
    }
}
