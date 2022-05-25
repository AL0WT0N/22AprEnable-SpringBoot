package com.qa.springbootexample.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.springbootexample.domain.User;
import com.qa.springbootexample.repo.UserRepo;

@Service
public class UserService {
	
	private UserRepo repo;
	
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public User create(User user) {
		return repo.saveAndFlush(user);
	}
	
	// ReadAll
	public List<User> getAll() {
		return repo.findAll();
	}
	
	// Read By ID
	public User getById(long id) {
		return repo.findById(id).get();
	}
	
	// Update
	public User update(long id, User user) {
		// First, get the existing entry
		User existing = repo.findById(id).get();
		
		// Then, updated the existing entry using the new object
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setUsername(user.getUsername());
		
		return repo.saveAndFlush(existing);
	}

	// Delete
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}	

}
