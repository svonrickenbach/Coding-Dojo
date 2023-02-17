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
        // TO-DO: Additional validations!
    	// TO-DO - Reject values:
        
    	// Find user in the DB by email
        // Reject if NOT present
        
        // Reject if BCrypt password match fails
    
        // Return null if result has errors
        // Otherwise, return the user object
        return null;
    }
}

