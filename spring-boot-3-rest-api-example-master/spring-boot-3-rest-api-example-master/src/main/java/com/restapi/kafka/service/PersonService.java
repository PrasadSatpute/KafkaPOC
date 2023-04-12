package com.restapi.kafka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.kafka.model.Person;

@Service
public class PersonService {
	
	static List<Person> listPerson = new ArrayList<Person>();
	
	public Person savePerosn(Person person)
	  {
		  listPerson.add(person);
		  return person;
	  }
	
	public List<Person> getAllperson()
	{
		return listPerson;
	}
}
