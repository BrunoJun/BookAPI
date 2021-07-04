package com.digitalinnovationone.projetoapilivros.controller;

import com.digitalinnovationone.projetoapilivros.entity.Person;
import com.digitalinnovationone.projetoapilivros.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class BookController {
    
    private PersonService personService;

    @Autowired
    public BookController(PersonService personService){

        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPerson(@RequestBody Person person){

        return personService.createPerson(person);
    }
}
