package com.qa.springbootexample.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.springbootexample.domain.User;
import com.qa.springbootexample.repo.UserRepo;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepo repo;

	// Create Test
	@Test
	public void createTest() {
		User input = new User("Tom", "Jones", "tjones1");
		User output = new User(1L, "Tom", "Jones", "tjones1");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, service.create(input));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
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
	@Test
	public void getByIdTest() {
		// Creating any expected output and inputs if necessary
		User output = new User(1L, "Tom", "Jones", "tjones1");
		Optional<User> optionalOutput = Optional.of(output);
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findById(1L)).thenReturn(optionalOutput);
		
		// Asserting the actual test method's output
		assertEquals(output, service.getById(1L));
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}

	// Update Test
	@Test
	public void updateTest() {
		// Creating any expected output and inputs if necessary
		User input = new User("Tom", "Jones", "tjones1");
		Optional<User> existing = Optional.of(new User(1L, "Jim", "Smith", "jsmith1"));
		User output = new User(1L, "Tom", "Jones", "tjones1");
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.update(1L, input));
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}

	// Read By FirstName Test
	@Disabled
	@Test
	public void getByFirstNameTest() {

	}
	
	// Delete Test
	@Disabled
	@Test
	public void deleteTest() {

	}
}
