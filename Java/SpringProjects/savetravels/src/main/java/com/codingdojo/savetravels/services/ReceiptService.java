package com.codingdojo.savetravels.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Receipt;
import com.codingdojo.savetravels.repositories.ReceiptRepository;

@Service
public class ReceiptService {
	private final ReceiptRepository receiptRepository; 
	
	public ReceiptService(ReceiptRepository receiptRepository) {
		this.receiptRepository = receiptRepository;
	}
	
	public List<Receipt> allReceipts(){
		return receiptRepository.findAll();
	}
	
    public Receipt createReceipt(Receipt b) {
        return receiptRepository.save(b);
    }
    // retrieves a receipt
    public Receipt findReceipt(Long id) {
        Optional<Receipt> optionalReceipt = receiptRepository.findById(id);
        if(optionalReceipt.isPresent()) {
            return optionalReceipt.get();
        } 
        else {
            return null;
        }	
    }
    // updates a receipt
    public Receipt updateReceipt(Receipt burger) {
    	return receiptRepository.save(burger);
    }
    // delete a receipt
    public void deleteReceipt(Long id) {
    	Optional<Receipt> optionalReceipt = receiptRepository.findById(id);
    	if(optionalReceipt.isPresent()) {
    		receiptRepository.deleteById(id);
    	}
    }
}
