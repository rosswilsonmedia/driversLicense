package com.codingdojo.driverslicense.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.services.LicenseService;
import com.codingdojo.driverslicense.services.PersonService;

@Controller
public class LicenseController {
	 private final LicenseService licenseService;
	 private final PersonService personService;
	 
	 public LicenseController(LicenseService licenseService, PersonService personService) {
	     this.licenseService = licenseService;
	     this.personService = personService;
	 }
	 
	  
	 @RequestMapping("/licenses/new")
	 public String newSong(@ModelAttribute("license") License license, Model model) {
		 model.addAttribute("persons", personService.allPersons());
		 return "/licenses/new.jsp";
	 }
	 
	 @RequestMapping(value="/licenses", method=RequestMethod.POST)
	 public String create(@RequestParam("person") Long personId, @RequestParam("state") String state, @RequestParam("expirationDate") String date) {
		 License license = new License();
		 Person selectedPerson = personService.findPerson(personId);
		 license.setPerson(selectedPerson);
		 license.setState(state);
		 System.out.println(date);
		 Date dateFormatted = null;
		 try {
			dateFormatted = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		 } catch (ParseException e) {
			e.printStackTrace();
		 }
		 license.setExpirationDate(dateFormatted);
		 licenseService.createLicense(license);
		 return "redirect:/licenses/new";
	 }
	 
}
