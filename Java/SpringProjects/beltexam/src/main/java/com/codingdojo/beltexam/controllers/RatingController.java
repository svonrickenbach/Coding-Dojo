package com.codingdojo.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.beltexam.models.Rating;
import com.codingdojo.beltexam.services.RatingService;
import com.codingdojo.beltexam.services.ShowService;

@Controller
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@Autowired
	ShowService showService;
	
	@PostMapping("/rating/{showId}")
	public String rating(@Valid @ModelAttribute("rating") Rating rating, 
				BindingResult result, HttpSession session, Model model, 
				@PathVariable("showId") Long showId) {
		
		Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	if(result.hasErrors()) {
        	model.addAttribute("userId", session.getAttribute("userId"));
        	model.addAttribute("show", showService.findShow(showId));
			return "displayShow.jsp";
		}
    	
    	System.out.println(rating.getRating());
		
    	ratingService.createRating(rating);
		
		return "redirect:/shows/" + showId;
	}

}
