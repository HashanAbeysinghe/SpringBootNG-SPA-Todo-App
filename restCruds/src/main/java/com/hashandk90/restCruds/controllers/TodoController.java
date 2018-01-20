package com.hashandk90.restCruds.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hashandk90.restCruds.models.Todo;
import com.hashandk90.restCruds.repositories.TodoRepository;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController {
	

	@Autowired
	TodoRepository todoRepo;
	
	@GetMapping("/all")
	public List<Todo> getAllTodos(){
		System.out.println("Get all called");
		return todoRepo.findAll();
	}
	
	@PostMapping("/add")
	public Todo createTodo(@Valid @RequestBody Todo todo){
		System.out.println("add called");
		todo.setCompleted(false);
		return todoRepo.save(todo);
	}
	
	@PutMapping("/update/{todoId}")
	public ResponseEntity<Todo> updateTodo(@Valid @RequestBody Todo todoIn, @PathVariable Long todoId){
		Todo todo = todoRepo.findOne(todoId);
		
		if(todo ==null){
			return ResponseEntity.notFound().build();
		}
		
		todo.setTitle(todoIn.getTitle());
		Todo updatedTodo = todoRepo.save(todo);
		return ResponseEntity.ok(updatedTodo);
	}
	
	@DeleteMapping("/delete/{todoId}")
	public void deleteTodo(@PathVariable Long todoId){
		todoRepo.delete(todoId);
	}
}
