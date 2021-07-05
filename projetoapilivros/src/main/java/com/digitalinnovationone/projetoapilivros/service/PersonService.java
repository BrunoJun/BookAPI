package com.digitalinnovationone.projetoapilivros.service;

import com.digitalinnovationone.projetoapilivros.dto.request.PersonDTO;
import com.digitalinnovationone.projetoapilivros.entity.Person;
import com.digitalinnovationone.projetoapilivros.mapper.PersonMapper;
import com.digitalinnovationone.projetoapilivros.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired //Injeta apenas o personRepository
    public PersonService(PersonRepository personRepository){

        this.personRepository = personRepository;
    }

    public String createPerson(PersonDTO personDTO){

    Person personToSave = personMapper.toModel(personDTO);

        personRepository.save(personToSave);
        return "Pessoa adicionada!";
    }
}
