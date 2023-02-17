package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;

@Controller
public class HomeController {
    
     @Autowired
     private UserService userServ;

    
    @GetMapping("/")
    public String index(
    		@ModelAttribute("newUser") User user,
    		@ModelAttribute("newLogin") LoginUser loginUser,
    		Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "loginAndReg.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Validated(User.class) @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User u = userServ.register(newUser, result);
    	 
    	if(u == null) {
             model.addAttribute("newLogin", new LoginUser());
             return "loginAndReg.jsp";
         }
    	
//    	userServ.register(newUser, result);
//    	
//    	if(result.hasErrors()) {
//            model.addAttribute("newLogin", new LoginUser());
//            return "loginAndReg.jsp";
//        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    	session.setAttribute("userId", u.getId());
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
        return "redirect:/home";
    }
    
}