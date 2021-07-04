package com.digitalinnovationone.projetoapilivros.controller;

import com.digitalinnovationone.projetoapilivros.entity.Person;
import com.digitalinnovationone.projetoapilivros.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookController {

    private PersonRepository personRepository;

    @Autowired //Injeta apenas o personRepository
    public BookController(PersonRepository personRepository){

        this.personRepository = personRepository;
    }
    
    @PostMapping
    public String createPerson(@RequestBody Person person){

        Person savedPerson = personRepository.save(person); // salvar um objeto no banco de dados.
        return "Pessoa Criada: " + savedPerson.getId();
    }
}
