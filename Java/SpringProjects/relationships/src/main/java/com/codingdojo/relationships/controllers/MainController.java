package com.codingdojo.relationships.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;




@Controller 
public class MainController {
	
	@Autowired
	PersonService personService;
	@Autowired 
	LicenseService licenseService;

	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.findPerson(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}
	
	
    @GetMapping("/")
    public String index(@ModelAttribute("person") Person person) {
        return "createPerson.jsp";
    }
    
    @GetMapping("/license")
    public String index(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", personService.allPersons());
        return "createLicense.jsp";
    }
    
    @PostMapping("/license/create")
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result, 
                         @RequestParam(value="expirationDate") String expirationDate, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("persons", personService.allPersons());
            return "createLicense.jsp";
        } else {
            license.setExpirationDateAsString(expirationDate);
            licenseService.createLicense(license);
            return "redirect:/";
        }
    }
    
    @PostMapping("/person/create")
    public String create(
        @Valid @ModelAttribute("person") Person person,
        BindingResult result, Model model)
    {
    	if (result.hasErrors()) {
    		return "index.jsp";
    	}
        // CODE TO MAKE A NEW RECEIPT AND SAVE TO THE DB
        personService.createPerson(person);
        return "redirect:/";
    }
    
    @GetMapping("/person/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "edit.jsp";
    }
    
    @PutMapping(value="/person/{id}/edit")
    public String update(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            personService.updatePerson(person);
            return "redirect:/";
        }
    }
    
    @DeleteMapping("/person/{id}")
    public String destroy(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/";
    }
    
    @GetMapping("/one/person/{personId}")
	public String index(Model model, @PathVariable("personId") Long personId) {
		
		Person person = personService.findPerson(personId);
		model.addAttribute("person", person);

		
		return "details.jsp";
	}
}