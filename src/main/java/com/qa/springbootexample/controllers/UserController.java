package com.qa.springbootexample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootexample.domain.User;

@RestController
public class UserController {
	
	// Temporary storage, until we implement the real database.
	private List<User> users = new ArrayList<>();
	
	// Read -> Get Request -@GetMapping
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return users;
	}
	
	// Create -> Post Request - @PostMapping
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		users.add(user);
		return users.get(users.size() - 1);
	}
	
	// Update -> Put/Patch Request - @PutMapping
	
	// Delete -> Delete Request - @DeleteMapping
	
}
