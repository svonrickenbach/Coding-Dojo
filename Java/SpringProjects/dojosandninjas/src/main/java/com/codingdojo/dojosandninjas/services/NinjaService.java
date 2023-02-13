package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository; 
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } 
        else {
            return null;
        }	
    }

    public Ninja updateNinja(Ninja ninja) {
    	return ninjaRepository.save(ninja);
    }

    public void deleteNinja(Long id) {
    	Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
    	if(optionalNinja.isPresent()) {
    		ninjaRepository.deleteById(id);
    	}
    }
}