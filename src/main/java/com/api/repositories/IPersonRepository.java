package com.api.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entities.Person;

@Repository("personRepository")
public interface IPersonRepository extends JpaRepository<Person, Serializable>{
	
	public Person findByIdPerson(long idPerson);
	
	public Person findByLastName(String lastName);
	
}
