package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.codingdojo.savetravels.models.Receipt;
import com.codingdojo.savetravels.services.ReceiptService;




@Controller 
public class ReceiptController {
	
	@Autowired
	ReceiptService receiptService;
	
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
    public String index(Model model, @ModelAttribute("receipt") Receipt receipt) {
        List<Receipt> receipts = receiptService.allReceipts();
        model.addAttribute("receipts", receipts);
        return "index.jsp";
    }
    
    @PostMapping("/receipt/create")
    public String create(
        @Valid @ModelAttribute("receipt") Receipt receipt,
        BindingResult result)
    {
    	if (result.hasErrors()) {
    		return "index.jsp";
    	}
        // CODE TO MAKE A NEW RECEIPT AND SAVE TO THE DB
        receiptService.createReceipt(receipt);
        return "redirect:/";
    }
    
    @GetMapping("/receipt/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Receipt receipt = receiptService.findReceipt(id);
        model.addAttribute("receipt", receipt);
        return "edit.jsp";
    }
    
    @PutMapping(value="/receipt/{id}/edit")
    public String update(@Valid @ModelAttribute("receipt") Receipt receipt, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            receiptService.updateReceipt(receipt);
            return "redirect:/";
        }
    }
    
    @DeleteMapping("/receipt/{id}")
    public String destroy(@PathVariable("id") Long id) {
        receiptService.deleteReceipt(id);
        return "redirect:/";
    }
    
    @GetMapping("/one/receipt/{receiptId}")
	public String index(Model model, @PathVariable("receiptId") Long receiptId) {
		
		Receipt receipt = receiptService.findReceipt(receiptId);
		model.addAttribute("receipt", receipt);

		
		return "details.jsp";
	}
    
}