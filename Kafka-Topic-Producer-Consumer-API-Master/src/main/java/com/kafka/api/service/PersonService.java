package com.kafka.api.service;

import java.util.Optional;

import com.kafka.api.model.Person;

public interface PersonService {
	Person savePerson(Person person);
	Optional<Person> getPerson(int id);
}
