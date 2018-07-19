package com.huawei.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.demo.demo.models.TodoList;
import com.huawei.demo.demo.models.TodoListRepository;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class TodoListController {
    private TodoListRepository todoListRepository;
    private static final AtomicLong counter = new AtomicLong();

    public TodoListController(TodoListRepository repository) {
        this.todoListRepository = repository;
    }

    // Gets all the todo lists.
    @GetMapping("/all-todoLists")
    public Collection<TodoList> goodTodoLists() {
    	return todoListRepository.findAll().stream()
        .collect(Collectors.toList());
    }
    
    // Gets todo list for specific id.
    @GetMapping("/todoList/{id}")
    public TodoList getTodoListById(Long id) {
    	return this.todoListRepository.findById(id).get();
    }
    
    // Creates a new todo list.
    @PostMapping("/create-todoList")
    public void createTodoList(@RequestBody TodoList todoList) {
    	if (!findByName(todoList.getName())) {
    		todoList.setId(counter.incrementAndGet());
    		this.todoListRepository.save(todoList);
    	}
    }
    
    // Deletes a todo list.
    @PostMapping("/delete-todoList")
    public void deleteTodoList(@RequestBody TodoList todoList) {
    	if (findByName(todoList.getName())) {
    		this.todoListRepository.delete(todoList);
    	}
    }
    
    // Finds todo list for specific name.
    public boolean findByName(String name) {
        for(TodoList todoList : this.todoListRepository.findAll()){
            if(todoList.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
}