package com.codingdojo.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller 
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("books", books);
		
		return "index2.jsp";
	}
	
    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    
    @GetMapping("books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	return "create.jsp";
    }
    
    @PostMapping("/books")
    public String create(
        @Valid @ModelAttribute("book") Book book,
        BindingResult result)
    {
    	if (result.hasErrors()) {
    		return "create.jsp";
    	}
        // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
        bookService.createBook(book);
        return "redirect:/books";
    }
	
}
