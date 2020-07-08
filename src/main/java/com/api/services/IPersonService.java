package com.api.services;

import java.util.List;

import com.api.entities.Person;

public interface IPersonService {
	
	public List<Person> getAll();
	
	public void insertOrUpdate(Person person);

}
