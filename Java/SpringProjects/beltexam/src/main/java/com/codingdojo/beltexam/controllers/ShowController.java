package com.codingdojo.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.beltexam.models.Rating;
import com.codingdojo.beltexam.models.Show;
import com.codingdojo.beltexam.services.RatingService;
import com.codingdojo.beltexam.services.ShowService;
import com.codingdojo.beltexam.services.UserService;

@Controller
public class ShowController {
	
	@Autowired
	ShowService showService;
	
	@Autowired
	UserService userServ;
	
	@Autowired
	RatingService ratingService;

//	Display all shows
    @GetMapping("/shows")
    public String shows(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	model.addAttribute("user", userServ.findById(userId));
    	model.addAttribute("shows", showService.allShows());
  
    	
    	return "dashboard.jsp";
    }
    
//  Add a show form 
	@GetMapping("/shows/new")
	public String formShow(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
   	if(userId == null) {
   		return "redirect:/";
   	}
		model.addAttribute("show", new Show());
		model.addAttribute("userId", session.getAttribute("userId"));
		return "create.jsp";
	}
	
//	Add a show
	@PostMapping("/shows")
	public String addShow(@Valid @ModelAttribute("show") Show newShow,
			BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		Show show = showService.createShow(newShow, result);
		
    	if(show == null) {
            return "create.jsp";
        }
		
		return "redirect:/shows";
	}
	
//	Display one show's details
	@GetMapping("/shows/{showId}")
	public String displayBook(Model model, @PathVariable("showId") Long id,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
		
		model.addAttribute("show", showService.findShow(id));
		model.addAttribute("userId", session.getAttribute("userId"));
		model.addAttribute("rating", new Rating());
		
		
		model.addAttribute("ratings", ratingService.getRatingsbyShow(id));
		
		
		
		return "displayShow.jsp";
	}
	
//	Editing Form
	@GetMapping("/shows/{showId}/edit")
	public String editBook(Model model, @PathVariable("showId") Long id,
			HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
		
		Long showUserId = showService.findShow(id).getUser().getId();
		
		if(!showUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/shows";
		}
		
		model.addAttribute("show", showService.findShow(id));
		
		
		return "edit.jsp";
	}
	
//	Update a show
	@PutMapping(value="shows/{id}")
	public String updateBook(@Valid @ModelAttribute("show") Show show, @PathVariable("id") Long id,
			BindingResult result, HttpSession session) {
		
		Long showUserId = showService.findShow(id).getUser().getId();
		
		if(!showUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/shows";
		}
		
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		showService.updateShow(show);
		return "redirect:/shows";
	}
	
//	Delete a Show
	@GetMapping("/shows/{id}/delete")
	public String destroyBook(@PathVariable("id") Long id, 
					HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
		Long showUserId = showService.findShow(id).getUser().getId();
		
		if(!showUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/shows";
		}
		
		showService.deleteShow(id);
		return "redirect:/shows";
	}
	
}
