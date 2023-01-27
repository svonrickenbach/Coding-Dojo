package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloHumanController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String searchQuery, @RequestParam(value="last_name", required= false) String searchQuery1, @RequestParam(value="times", required= false) Integer multiplier) {
		if(searchQuery1 == null && searchQuery == null && multiplier != null) {
			String string = "Hello Human ";
			return string.repeat(multiplier);
		}
		else if (searchQuery1 == null && searchQuery == null && multiplier == null){
				return "Hello Human";
		}
		else if(searchQuery1 == null && multiplier == null) {
			return "Hello " + searchQuery;
		}
		else if(searchQuery1 == null && multiplier != null) {
			String string = String.format("Hello %s ", searchQuery);
			return string.repeat(multiplier);
		}
		else if(searchQuery1 != null && searchQuery != null && multiplier != null){
			String string = String.format("Hello %s %s ", searchQuery, searchQuery1);
			return string.repeat(multiplier);
		}
		else {
			return "Hello " + searchQuery + " " + searchQuery1;
		}
	}
}
