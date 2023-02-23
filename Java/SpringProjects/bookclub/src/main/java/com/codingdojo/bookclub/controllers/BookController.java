package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
//	Display all books
    @GetMapping("/books")
    public String books(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	model.addAttribute("user", userServ.findById(userId));
    	model.addAttribute("books", bookService.allBooks());
    	
    	return "dashboard.jsp";
    }
    
//   Add a book form 
	@GetMapping("/books/new")
	public String formBook(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
		model.addAttribute("book", new Book());
		model.addAttribute("userId", session.getAttribute("userId"));
		return "create.jsp";
	}
	
//	Add a book
	@PostMapping("/books")
	public String addBook(@Valid @ModelAttribute("book") Book newBook,
			BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		bookService.createBook(newBook);
		
		return "redirect:/books";
	}
	
//	Display one book
	@GetMapping("/books/{bookId}")
	public String displayBook(Model model, @PathVariable("bookId") Long id,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
		
		model.addAttribute("book", bookService.findBook(id));
		model.addAttribute("userId", session.getAttribute("userId"));
		
		return "displayBook.jsp";
	}
	
//	Editing Form
	@GetMapping("/books/{bookId}/edit")
	public String editBook(Model model, @PathVariable("bookId") Long id,
			HttpSession session) {
		
		Long bookUserId = bookService.findBook(id).getUser().getId();
		
		if(!bookUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/books";
		}
		
		model.addAttribute("book", bookService.findBook(id));
		
		Long borrowerId = bookService.findBook(id).getBorrower().getId();
		System.out.println(borrowerId);
		
		return "edit.jsp";
	}
	
//	Update a book
	@PutMapping(value="books/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/books";
	}
	
//	Delete a Book, changed it to GetMapping to allow for not being in a form 
	@GetMapping("/books/{id}/delete")
	public String destroyBook(@PathVariable("id") Long id, 
					HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
		Long bookUserId = bookService.findBook(id).getUser().getId();
		
		if(!bookUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/books";
		}
		
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
//	Book Market Routes
	
//	Show the book market books 
	@GetMapping("/bookmarket")
	public String bookMarket(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("books", bookService.allBooks());
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("borrowedBooks", userServ.findById(userId).getBorrowedBooks());
		
		return "bookBroker.jsp";
	}

//	Borrow a book 
	@GetMapping("/bookmarket/{id}/borrow")
	public String borrowBook(Model model, HttpSession session, @PathVariable("id") Long id) {
		
		Long userId = (Long) session.getAttribute("userId");
		
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
		Long bookUserId = bookService.findBook(id).getUser().getId();
		
		if(bookUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/bookmarket";
		}
		
		Book book = bookService.findBook(id);
		book.setBorrower(userServ.findById((Long)session.getAttribute("userId")));
		bookService.updateBook(book);
			
		return "redirect:/bookmarket";
	}
	
	@GetMapping("/bookmarket/{id}/return")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
		Long bookUserId = bookService.findBook(id).getUser().getId();
		
		if(bookUserId.equals(session.getAttribute("userId"))) {
			return "redirect:/bookmarket";
		}
		
		Book book = bookService.findBook(id);
		book.setBorrower(null);
		bookService.updateBook(book);
		
		return "redirect:/bookmarket";
	}
	
}
