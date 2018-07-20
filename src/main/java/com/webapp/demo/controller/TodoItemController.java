package com.webapp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.models.TodoItem;
import com.webapp.demo.models.TodoItemRepository;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class TodoItemController {
	private TodoItemRepository todoItemRepository;
	private static final AtomicLong counter = new AtomicLong();
	
	public TodoItemController(TodoItemRepository repository) {
    	this.todoItemRepository = repository;
    }
	
	// Gets all the todo items.
	@GetMapping("/all-todoItems")
    public Collection<TodoItem> getTodoItems() {
        return todoItemRepository.findAll().stream()
                .collect(Collectors.toList());
    }
	
	//	Gets todo item for specific id.
	@GetMapping("/todoItem/{id}")
	public TodoItem getTodoItemById(Long id) {
		return todoItemRepository.findById(id).get();
	}
	
	// Creates a new todo item.
	@PostMapping("/create-todoItem")
    public void createTodoItem(@RequestBody TodoItem todoItem) {
    	if (!findByName(todoItem.getName())) {
    		todoItem.setId(counter.incrementAndGet());
    		this.todoItemRepository.save(todoItem);
    	}
    }
    
	// Deletes a todo item.
    @PostMapping("/delete-todoItem")
    public void deleteTodoItem(@RequestBody TodoItem todoItem) {
    	if (findByName(todoItem.getName())) {
    		this.todoItemRepository.delete(todoItem);
    	}
    }
	
    // Finds todo item for specific name.
	public boolean findByName(String name) {
        for(TodoItem todoItem : this.todoItemRepository.findAll()){
            if(todoItem.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
}