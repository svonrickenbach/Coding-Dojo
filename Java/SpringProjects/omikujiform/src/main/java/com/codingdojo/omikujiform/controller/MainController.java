package com.codingdojo.omikujiform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping("/")
	public String omikujiForm() {
	
		return "omikuji.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(
		@RequestParam(value="number") int number,
		@RequestParam(value="cityName") String cityName,
		@RequestParam(value="personName") String personName,
		@RequestParam(value="hobby") String hobby, 
		@RequestParam(value="livingThing") String livingThing,
		@RequestParam(value="niceMessage") String niceMessage, HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(number < 5 || number > 25) {
			redirectAttributes.addFlashAttribute("error", "Plesase enter a number between 5 and 25!");
			return "redirect:/";
		}
		else {
			session.setAttribute("number", number);
			session.setAttribute("cityName", cityName);
			session.setAttribute("personName", personName);
			session.setAttribute("hobby", hobby);
			session.setAttribute("livingThing", livingThing);
			session.setAttribute("niceMessage", niceMessage);
		
			return "redirect:/omikuji";
		}
	}
	
	@RequestMapping("/omikuji")
	public String omikujiResults() {
		
		
		return "omikujiresults.jsp";
	}
}
