package com.example.todobackend.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todo {
    // TODO: replace this with a database
    private static final List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    private final int id;
    private String content;

    public Todo(String content) {
        this.id = ++idCounter;
        this.content = content;

        todos.add(this);
    }

    public static List<Todo> all() {
        // TODO: actually use a database
        return Collections.unmodifiableList(Todo.todos);
    }

    public static Todo byId(int id) {
        // TODO: actually use a database
        return Todo.todos.stream().filter(todo -> todo.id == id).findFirst().orElseThrow();
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void delete() {
        // TODO: actually use a database
        todos.remove(this);
    }

    public int getId() {
        return id;
    }
}
