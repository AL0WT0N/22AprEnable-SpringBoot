package com.qa.springbootexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	// Read -> Get Request -@GetMapping
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	// Create -> Post Request - @PostMapping
	
	// Update -> Put/Patch Request - @PutMapping
	
	// Delete -> Delete Request - @DeleteMapping
	
}
