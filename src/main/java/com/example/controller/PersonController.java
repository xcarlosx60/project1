package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Person;
import com.example.persistence.PersonRepository;
import com.example.service.PersonService;

@RestController
@RequestMapping("/rest")
public class PersonController {
@Autowired	
PersonService service;

@PostMapping
public void agregar(@RequestBody Person persona) {
	service.savePersona(persona);
}

@GetMapping
public List<Person> getall(){
	return service.getPersona();
}
@GetMapping(value = "/{id}")
public Person saludos(@PathVariable("id") Integer id) {
	return service.getPersonabyID(id);
}

@DeleteMapping(value = "/{id}")
public void delete(@PathVariable("id") Integer id) {
	service.deletePersonByID(id);
}

@PutMapping
public void update(@RequestBody Person persona) {
	service.update(persona);
}

}
