package com.codingdojo.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/category")
	public String gCategory(Model model) {
		model.addAttribute("category", new Product());
		return "newCategory.jsp";
	}
	
	@PostMapping("/category")
	public String pCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		
		categoryService.createCategory(category);
		
		return "redirect:/";
	}
}

