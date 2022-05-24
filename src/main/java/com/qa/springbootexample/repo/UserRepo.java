package com.qa.springbootexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.springbootexample.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	// No need to write any code here... for now.
}
