package com.codingdojo.beltexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltexam.models.Show;

public interface ShowRepository extends CrudRepository<Show, Long>{
	List<Show> findAll();
	Optional<Show> findShowByTitle(String title);
//	Show findByIdIs(Long id);
//	List<Show> findAllByUser(User category);
//	List<Show> findByUsersNotContains(User category);
}

