package com.codingdojo.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.CategoryService;
import com.codingdojo.productsandcategories.services.ProductService;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

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
	
	@GetMapping("/category/{id}")
	public String sCategory(Model model, @PathVariable("id") Long id) {
		
		Category currentCategory = categoryService.findById(id);
		model.addAttribute("category", currentCategory);
		model.addAttribute("unassignedProducts", productService.getUnassignedProducts(currentCategory));
		model.addAttribute("assignedProducts", productService.getAssignedProducts(currentCategory));
		
		return "showCategories.jsp";
	}
	
	@PostMapping("/category/{id}")
	public String addProduct(Model model, @PathVariable("id") Long id,
			@RequestParam(value="productId") Long productId) {
		
		Category category = categoryService.findById(id);
		Product product = productService.findById(productId);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		
		return "redirect:/category/" +id;
	}
	
}

