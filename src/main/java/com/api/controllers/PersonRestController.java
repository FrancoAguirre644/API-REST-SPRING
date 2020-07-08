package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("")
	public List<Person> getAllPersons() {
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

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long idPerson) {
		PersonService.remove(idPerson);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> get(@PathVariable("id") long idPerson) {

		if (PersonService.findByidPerson(idPerson) == null) {
			return new ResponseEntity<Person>(PersonService.findByidPerson(idPerson), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Person>(PersonService.findByidPerson(idPerson), HttpStatus.OK);
		}

	}

	@GetMapping("byLastName/{Lastname}")
	public ResponseEntity<Person> getByLastName(@PathVariable("Lastname") String lastName) {

		if (PersonService.findByLastName(lastName) == null) {
			return new ResponseEntity<Person>(PersonService.findByLastName(lastName), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Person>(PersonService.findByLastName(lastName), HttpStatus.OK);
		}

	}

}
