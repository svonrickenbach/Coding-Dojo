package com.codingdojo.beltexam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltexam.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long>, JpaRepository<Rating, Long> {
	List<Rating> findAll();
	List<Rating> findAllByShowIdOrderByRatingDesc(Long showId);
	
}