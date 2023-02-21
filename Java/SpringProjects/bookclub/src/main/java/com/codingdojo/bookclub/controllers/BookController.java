package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userServ;
	
    @GetMapping("/books")
    public String welcome(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	model.addAttribute("user", userServ.findById(userId));
    	model.addAttribute("books", bookService.allBooks());
    	
    	return "dashboard.jsp";
    }
    
	@GetMapping("/books/new")
	public String bookForm(Model model, HttpSession session) {
		model.addAttribute("book", new Book());
		model.addAttribute("userId", session.getAttribute("userId"));
		return "create.jsp";
	}
	
	@PostMapping("/books/new/add")
	public String addBook(@Valid @ModelAttribute("book") Book newBook,
			BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		bookService.createBook(newBook);
		
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}")
	public String display(Model model, @PathVariable("bookId") Long id,
			HttpSession session) {
		
		model.addAttribute("book", bookService.findBook(id));
		model.addAttribute("userId", session.getAttribute("userId"));
		
		return "displayBook.jsp";
	}
	
	@GetMapping("/books/{bookId}/edit")
	public String edit(Model model, @PathVariable("bookId") Long id) {
		
		model.addAttribute("book", bookService.findBook(id));
		
		return "edit.jsp";
	}
	
	@PutMapping(value="books/{id}")
	public String update(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/books";
	}
	
	@DeleteMapping("/books/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
}
