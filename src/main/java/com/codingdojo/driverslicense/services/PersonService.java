package com.codingdojo.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    
    public Person createPerson(Person p) {
        return personRepository.save(p);
    }
    
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
    public void deletePerson(Long id) {
    	personRepository.deleteById(id);
    }
    
    public Person updatePerson(Long id, String firstName, String lastName) {
    	Person updatedPerson = findPerson(id);
    	if(updatedPerson!=null) {
    		updatedPerson.setFirstName(firstName);
    		updatedPerson.setLastName(lastName);
    		personRepository.save(updatedPerson);
    	}
    	return updatedPerson;
    }
    
}