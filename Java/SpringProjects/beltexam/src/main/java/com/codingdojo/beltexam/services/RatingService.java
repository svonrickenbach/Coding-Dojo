package com.codingdojo.beltexam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.Rating;
import com.codingdojo.beltexam.repositories.RatingRepository;

@Service
public class RatingService {	
	private final RatingRepository ratingRepository;
	
	public RatingService(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}
	
	// returns all the ratings
    public List<Rating> allRatings() {
        return ratingRepository.findAll();
    }
    // creates a rating
    public Rating createRating(Rating newRating) {
    	
        return ratingRepository.save(newRating);
    }
    
//  Get Ratings by userId and showId
  public List<Rating> getRatingsbyShow(Long showId){
		return ratingRepository.findAllByShowIdOrderByRatingDesc(showId);
	}
 
  
}