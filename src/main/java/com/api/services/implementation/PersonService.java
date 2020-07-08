package com.api.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.entities.Person;
import com.api.repositories.IPersonRepository;
import com.api.services.IPersonService;

@Service("personService")
public class PersonService implements IPersonService{
	
	@Autowired
	@Qualifier("personRepository")
	private IPersonRepository personRepository;

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub 
		return personRepository.findAll();
	}

	@Override
	public void insertOrUpdate(Person person) {
		// TODO Auto-generated method stub
		personRepository.save(person);
	}

	@Override
	public void remove(long idPersona) {
		// TODO Auto-generated method stub
		personRepository.deleteById(idPersona);
	}

	@Override
	public Person findByidPerson(long idPerson) {
		// TODO Auto-generated method stub
		return personRepository.findByIdPerson(idPerson);
	}

	@Override
	public Person findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return personRepository.findByLastName(lastName);
	}
	
	
	
	

}
