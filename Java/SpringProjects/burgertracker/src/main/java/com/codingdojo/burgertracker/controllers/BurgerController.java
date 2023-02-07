package com.codingdojo.burgertracker.controllers;

import java.awt.print.Book;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.services.BurgerService;



@Controller 
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
//	@GetMapping("/books/{bookId}")
//	public String index(Model model, @PathVariable("bookId") Long bookId) {
//		
//		System.out.println(bookId);
//		Book book = bookService.findBook(bookId);
//		System.out.println(book);
//		
//		ArrayList<Book> books = (ArrayList<Book>) bookService.allBurgers();
//		
//		model.addAttribute("book", book);
//		model.addAttribute("books", books);
//		
//		return "index2.jsp";
//	}
	
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("burger") Burger burger) {
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index.jsp";
    }
    
    @PostMapping("/burgers")
    public String create(
        @Valid @ModelAttribute("burger") Burger burger,
        BindingResult result)
    {
    	if (result.hasErrors()) {
    		return "redirect:/";
    	}
        // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
        burgerService.createBurger(burger);
        return "redirect:/";
    }
	
}