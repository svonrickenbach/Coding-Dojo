package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/hello")
public class HomeController {
	
	@GetMapping("")
	public String index() {
		return "Hello World!";
	}
	
	@GetMapping("/new_route")
	public String Woo() {
		return "WOOOOOOOOOOOO!!!!!!!";
	}
}
