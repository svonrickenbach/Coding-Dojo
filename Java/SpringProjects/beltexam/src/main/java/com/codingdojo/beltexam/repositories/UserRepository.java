package com.codingdojo.beltexam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltexam.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email); 
//	Optional<User> findUserByUserName(String userName);
}
