package com.qa.springbootexample.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.springbootexample.domain.User;
import com.qa.springbootexample.services.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	// Read -> Get Request -@GetMapping
	// Read ALL
	@GetMapping("/getAll")
	public List<User> getAll() {
		return service.getAll();
	}
	
	// Read By ID
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	// Create -> Post Request - @PostMapping
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	
	// Update -> Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public User update(@PathVariable long id, @RequestBody User user) {
		return service.update(id, user);
	}

	// Delete -> Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public User delete(@PathVariable long id) {
		return service.delete(id);
	}
}
