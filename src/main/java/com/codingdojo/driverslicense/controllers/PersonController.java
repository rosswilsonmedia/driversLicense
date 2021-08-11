package com.codingdojo.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.services.PersonService;

@Controller
public class PersonController {
	 private final PersonService personService;
	 
	 public PersonController(PersonService personService) {
	     this.personService = personService;
	 }
	 
	  
	 @RequestMapping("/persons/new")
	 public String newSong(@ModelAttribute("person") Person person) {
		 return "/persons/new.jsp";
	 }
	 
	 @RequestMapping(value="/persons", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		 if (result.hasErrors()) {
			 return "/persons/new.jsp";
		 } else {
			 personService.createPerson(person);
			 return "redirect:/persons/new";
		 }
	 }
	 
	 @RequestMapping("/persons/{id}")
	 public String viewOne(@PathVariable("id") Long id, Model model) {
		 Person person = personService.findPerson(id);
		 model.addAttribute("person", person);
		 return "/persons/view.jsp";
	 }
	 
}
