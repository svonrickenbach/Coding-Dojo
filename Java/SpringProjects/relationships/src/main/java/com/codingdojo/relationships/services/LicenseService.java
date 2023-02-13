package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository; 
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
    public License createLicense(License b) {
        return licenseRepository.save(b);
    }
    // retrieves a receipt
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } 
        else {
            return null;
        }	
    }
    // updates a receipt
    public License updateLicense(License burger) {
    	return licenseRepository.save(burger);
    }
    // delete a receipt
    public void deleteLicense(Long id) {
    	Optional<License> optionalLicense = licenseRepository.findById(id);
    	if(optionalLicense.isPresent()) {
    		licenseRepository.deleteById(id);
    	}
    }
}
