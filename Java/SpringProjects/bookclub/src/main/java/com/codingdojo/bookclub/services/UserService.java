package com.codingdojo.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    

    public User register(User newUser, BindingResult result) {

    		if(result.hasErrors()) {
        		return null;
        }
    		
    		Optional<User> userEmail = userRepo.findByEmail(newUser.getEmail());
   
    		
    		if(userEmail.isPresent()) {
    			result.rejectValue("email", "email", "Email already exists. Please login!");
    			return null;
    		}
  
    		if(!newUser.getPassword().equals(newUser.getConfirm())) {
    			result.rejectValue("confirm", "passwords do not match", "Passwords must match!");
    			return null;
    		}
    	
    		String hashedPw = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashedPw);
        
    		return userRepo.save(newUser);
    }
    

    public User login(LoginUser newLoginObject, BindingResult result) {
    	
        if(result.hasErrors()) {
        	return null; 
        }
        
        Optional<User> loginEmail = userRepo.findByEmail(newLoginObject.getEmail());
       
        if(!loginEmail.isPresent()) {
        	result.rejectValue("email", "email", "This email is not registered.");
        	return null; 
        }
        
        User user = userRepo.findUserByEmail(newLoginObject.getEmail());
        
        
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "Invalid Password!");
  		}
      
        return user;
    }
    
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
}


