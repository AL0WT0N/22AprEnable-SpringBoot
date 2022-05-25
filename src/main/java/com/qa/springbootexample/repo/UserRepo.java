package com.qa.springbootexample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.springbootexample.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	// SELECT * FROM user WHERE firstname = ?1" 
	List<User> findByFirstName(String firstName);
	
}
