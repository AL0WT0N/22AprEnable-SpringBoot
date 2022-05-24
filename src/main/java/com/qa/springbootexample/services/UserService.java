package com.qa.springbootexample.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.springbootexample.domain.User;

@Service
public class UserService {
	
	// Temporary storage, until we implement the real database.
	private List<User> users = new ArrayList<>();
	
	public List<User> getAll() {
		return users;
	}
	
	public User getById(long id) {
		return users.get((int)id);
	}
	
	public User create(User user) {
		users.add(user);
		return users.get(users.size() - 1);
	}
	
	public User update(long id, User user) {
		// Remove the original user
		users.remove((int)id);
		// Add the updated user
		users.add((int)id, user);
		// Return the updated user
		return users.get((int)id);
	}

	public User delete(long id) {
		return users.remove((int)id);
	}	
}
