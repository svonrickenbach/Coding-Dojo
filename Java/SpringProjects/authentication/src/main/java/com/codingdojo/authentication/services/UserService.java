package com.codingdojo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
//      If Errors exist, reject the values
    		if(result.hasErrors()) {
        		return null;
        }
    		
//    	If no form errors exist check to see whether or not the email is already in the database.
    		
    		Optional<User> userEmail = userRepo.findByEmail(newUser.getEmail());
   
    		
//    	If the email exists, reject the value ("1", "2", "3"), where 1 = the field, 2 = the error code (not visible to user), and 3 = the error message...
    		
    		if(userEmail.isPresent()) {
    			result.rejectValue("email", "email", "Email already exists. Please login!");
    			return null;
    		}
    		
//    	Check to see if the password and confirm password fields match, if they do not, reject the value and show an error.
    		
    		if(!newUser.getPassword().equals(newUser.getConfirm())) {
    			result.rejectValue("confirm", "passwords do not match", "Passwords must match!");
    			return null;
    		}
//    	Hash the password and save it to the model object
    	
    		String hashedPw = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashedPw);
        
    		return userRepo.save(newUser);
    }
    

    public User login(LoginUser newLoginObject, BindingResult result) {
    	
    	// Reject values:
        if(result.hasErrors()) {
        	return null; 
        }
        
    	// Find user in the DB by email
        Optional<User> loginEmail = userRepo.findByEmail(newLoginObject.getEmail());
       
        // Reject if NOT present
        if(!loginEmail.isPresent()) {
        	result.rejectValue("email", "email", "This email is not registered.");
        	return null; 
        }
        
        // Reject if BCrypt password match fails
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

