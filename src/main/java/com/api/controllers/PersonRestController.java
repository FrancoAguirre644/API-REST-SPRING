package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Person;
import com.api.services.IPersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonRestController {
	
	@Autowired
	@Qualifier("personService")
	private IPersonService PersonService;
	
	@GetMapping("/list")
	public List<Person> getAllPersons(){
		return PersonService.getAll();
	}
	
	@PostMapping("/new")
	public void create(@RequestBody Person person) {
		PersonService.insertOrUpdate(person);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Person person) {
		PersonService.insertOrUpdate(person);
	}
	

}
