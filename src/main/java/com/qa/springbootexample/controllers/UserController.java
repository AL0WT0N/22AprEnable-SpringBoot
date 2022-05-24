package com.qa.springbootexample.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootexample.domain.User;

@RestController
public class UserController {
	
	// Temporary storage, until we implement the real database.
	private List<User> users = new ArrayList<>();
	
	// Read -> Get Request -@GetMapping
	// Read ALL
	@GetMapping("/getAll")
	public List<User> getAll() {
		return users;
	}
	
	// Read By ID
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable long id) {
		return users.get((int)id);
	}
	
	// Create -> Post Request - @PostMapping
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		users.add(user);
		return users.get(users.size() - 1);
	}
	
	// Update -> Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public User update(@PathVariable long id, @RequestBody User user) {
		// Remove the original user
		users.remove((int)id);
		// Add the updated user
		users.add((int)id, user);
		// Return the updated user
		return users.get((int)id);
	}
	
//  Update with Path Parameter -> @PutMapping
//	@PutMapping("/updateWithParam")
//	public User updateWithParam(@PathParam("id") long id, @RequestBody User user) {
//		// Remove the original user
//		users.remove((int)id);
//		// Add the updated user
//		users.add((int)id, user);
//		// Return the updated user
//		return users.get((int)id);
//	}
	
	// Delete -> Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public User delete(@PathVariable long id) {
		return users.remove((int)id);
	}
}
