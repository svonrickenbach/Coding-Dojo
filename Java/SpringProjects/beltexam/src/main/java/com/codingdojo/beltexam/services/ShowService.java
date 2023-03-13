package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.beltexam.models.Show;
import com.codingdojo.beltexam.repositories.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepo;
	
	private final ShowRepository showRepository;
	
	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}
	
	// returns all the shows
    public List<Show> allShows() {
        return showRepository.findAll();
    }
    // creates a show
    public Show createShow(Show newShow, BindingResult result) {
		
    	Optional<Show> title = showRepo.findShowByTitle(newShow.getTitle());
		
    	System.out.println(title);
    	
		if(title.isPresent()) {
			result.rejectValue("title", "title", "That title already exists!");
			return null;
		}
    	
        return showRepository.save(newShow);
    }
    // retrieves a show
    public Show findShow(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        if(optionalShow.isPresent()) {
            return optionalShow.get();
        } 
        else {
            return null;
        }	
    }
    // updates a show
    public Show updateShow(Show book) {
    	return showRepository.save(book); 
    }
    // delete a show
    public void deleteShow(Long id) {
    	Optional<Show> optionalShow = showRepository.findById(id);
    	if(optionalShow.isPresent()) {
    		showRepository.deleteById(id);
    	}
    }   
}