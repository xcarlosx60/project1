package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.domain.Person;
import com.example.persistence.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personaRepo;
	private Person persona = new Person();
	
	public void savePersona(Person persona) {
		personaRepo.save(persona);
	}
	
	public List<Person> getPersona() {
		
		return personaRepo.findAll();
		
	}
	
	public Person getPersonabyID(int id){
		return personaRepo.findById(id).get();
	}
	
	public void deletePersonByID(Integer id) {
		personaRepo.deleteById(id);
	}
	
	public void update(Person person) {
		
		personaRepo.deleteById(person.getId());
		personaRepo.save(person);
	}
	
	
}
