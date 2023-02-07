package com.codingdojo.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.savetravels.models.Receipt;

	@Repository
	public interface ReceiptRepository extends CrudRepository<Receipt, Long>{
		List<Receipt> findAll();
	}

