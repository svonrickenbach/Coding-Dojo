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
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/product")
	public String gProduct(Model model) {
		model.addAttribute("product", new Product());
		return "newProduct.jsp";
	}
	
	@PostMapping("/product")
	public String pProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		
		productService.createProduct(product);
		
		return "redirect:/";
	}
	
	@GetMapping("product/{id}")
	public String sProduct(Model model, @PathVariable("id") Long id) {
		
		Product currentProduct = productService.findById(id);
		model.addAttribute("product", currentProduct);
		
		model.addAttribute("unusedCategories", categoryService.getUnassignedCategories(currentProduct));
		model.addAttribute("usedCategories", categoryService.getAssignedCategories(currentProduct));
		
		return "showProduct.jsp";
	}
	
	@PostMapping("product/{id}")
	public String addCategory(Model model, @PathVariable("id") Long id, 
			@RequestParam(value="categoryId") Long categoryId) {
		
		Product product = productService.findById(id);
		Category category = categoryService.findById(categoryId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		
		return "redirect:product/" + id;
	}
}

