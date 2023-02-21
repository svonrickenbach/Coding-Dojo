package com.codingdojo.authentication.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.authentication.models.User;


	public interface UserRepository extends CrudRepository<User, Long>{
		Optional<User> findByEmail(String email); 
		User findUserByEmail(String email);
	}
