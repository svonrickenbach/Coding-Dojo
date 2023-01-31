package com.codingdojo.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		}
		System.out.println(session.getAttribute("count"));
		return "your_server.jsp";
	}
	
	@RequestMapping("/counter")
	public String index(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		
		return "counter.jsp";
	}
	
	@RequestMapping("/by2")
	public String byTwo(HttpSession session) {
		session.setAttribute("count", (Integer) session.getAttribute("count") + 2);
		
		return "byTwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "counter.jsp";
	}
}
