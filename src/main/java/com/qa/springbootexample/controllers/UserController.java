package com.qa.springbootexample.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import com.qa.springbootexample.domain.User;
import com.qa.springbootexample.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	// Read -> Get Request -@GetMapping
	// Read ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// Read By ID
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) {
		return new ResponseEntity<User>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getByFirstName/{name}")
	public ResponseEntity<List<User>> getByFirstName(@PathVariable String name) {
		return new ResponseEntity<List<User>>(service.getByFirstName(name), HttpStatus.OK);
	}
	
	// Create -> Post Request - @PostMapping
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
	
	// Update -> Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		return new ResponseEntity<User>(service.update(id, user), HttpStatus.ACCEPTED);
	}

//	 Delete -> Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
