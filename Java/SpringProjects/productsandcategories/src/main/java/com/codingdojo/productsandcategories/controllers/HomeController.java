package com.codingdojo.productsandcategories.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired 
	ProductService productService;
	
	@Autowired 
	CategoryService categoryService;
	
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
	
		return "homePage.jsp";
}
}
