package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping("")
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping("/new_route")
	public String Woo() {
		return "WOOOOOOOOOOOO!!!!!!!";
	}
}
