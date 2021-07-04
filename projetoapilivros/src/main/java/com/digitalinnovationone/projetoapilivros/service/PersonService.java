package com.digitalinnovationone.projetoapilivros.service;

import com.digitalinnovationone.projetoapilivros.entity.Person;
import com.digitalinnovationone.projetoapilivros.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    @Autowired //Injeta apenas o personRepository
    public PersonService(PersonRepository personRepository){

        this.personRepository = personRepository;
    }

    public String createPerson(Person person){

        personRepository.save(person);
        return "Pessoa adicionada!";
    }
}
