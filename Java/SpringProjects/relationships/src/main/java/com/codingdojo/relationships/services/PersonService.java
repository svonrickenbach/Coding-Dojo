package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository; 
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }
    // retrieves a receipt
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } 
        else {
            return null;
        }	
    }
    // updates a receipt
    public Person updatePerson(Person burger) {
    	return personRepository.save(burger);
    }
    // delete a receipt
    public void deletePerson(Long id) {
    	Optional<Person> optionalPerson = personRepository.findById(id);
    	if(optionalPerson.isPresent()) {
    		personRepository.deleteById(id);
    	}
    }
}
