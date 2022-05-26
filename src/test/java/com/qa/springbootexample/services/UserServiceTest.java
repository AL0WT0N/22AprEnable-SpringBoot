package com.qa.springbootexample.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.springbootexample.domain.User;
import com.qa.springbootexample.repo.UserRepo;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepo repo;

	// Create Test
	@Disabled
	@Test
	public void createTest() {

	}

	// ReadAll Test
	@Test
	public void getAllTest() {
		// Creating any expected output and inputs if necessary
		List<User> output = new ArrayList<>();
		output.add(new User(1L, "Tom", "Jones", "tjones1"));
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findAll()).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.getAll());
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).findAll(); 
	}

	// Read By ID Test
	@Disabled
	@Test
	public void getByIdTest() {

	}

	// Read By FirstName Test
	@Disabled
	@Test
	public void getByFirstNameTest() {

	}

	// Update Test
	@Disabled
	@Test
	public void updateTest() {

	}
	
	// Delete Test
	@Disabled
	@Test
	public void deleteTest() {

	}

}
