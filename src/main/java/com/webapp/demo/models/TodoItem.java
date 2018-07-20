package com.webapp.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TodoItem {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="deadLine", nullable = false)
	private Date deadLine;
	
	@Column(name="status", nullable = false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "TodoList_ID", nullable = false)
	private TodoList todoList;
	
	public TodoItem() {}

    public TodoItem(String name, String description, Date deadLine, boolean status) {
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
    
    public boolean getStatus() {
    	return status;
    }
    
    public void setStatus(boolean status) {
    	this.status = status;
    }
    
    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}