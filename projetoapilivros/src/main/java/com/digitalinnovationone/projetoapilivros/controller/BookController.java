package com.digitalinnovationone.projetoapilivros.controller;

import java.util.List;

import javax.validation.Valid;

import com.digitalinnovationone.projetoapilivros.dto.request.PersonDTO;
import com.digitalinnovationone.projetoapilivros.exception.PersonNotFoundException;
import com.digitalinnovationone.projetoapilivros.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String createPerson(@RequestBody @Valid PersonDTO personDTO){

        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){

        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{

        return personService.findById(id);
    }

} 
