package com.codingdojo.driverslicense.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;
    
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    
    public License createLicense(License l) {
        return licenseRepository.save(l);
    }
    
    public License findLicense(Long id) {
        Optional<License> optionalPerson = licenseRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
    public void deleteLicense(Long id) {
    	licenseRepository.deleteById(id);
    }
    
    public License updateLicense(Long id, Date expirationDate, String state) {
    	License updatedLicense = findLicense(id);
    	if(updatedLicense!=null) {
    		updatedLicense.setExpirationDate(expirationDate);
    		updatedLicense.setState(state);
    		licenseRepository.save(updatedLicense);
    	}
    	return updatedLicense;
    }
    
}