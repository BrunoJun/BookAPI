package com.digitalinnovationone.projetoapilivros.service;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalinnovationone.projetoapilivros.dto.request.PersonDTO;
import com.digitalinnovationone.projetoapilivros.dto.response.MessageResponseDTO;
import com.digitalinnovationone.projetoapilivros.entity.Person;
import com.digitalinnovationone.projetoapilivros.exception.PersonNotFoundException;
import com.digitalinnovationone.projetoapilivros.mapper.PersonMapper;
import com.digitalinnovationone.projetoapilivros.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        personRepository.save(personToSave);
        
        return MessageResponseDTO.builder().message("Pessoa adicionada").build();
    }

    public List<PersonDTO> listAll(){

        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
        .map(personMapper::toDTO)
        .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{

        Person person = verifyIfExists(id) ;

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException{

        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException{ 
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatePerson = personRepository.save(personToUpdate);
        
        return MessageResponseDTO.builder().message("Pessoa atualizada - Id: " + updatePerson.getId()).build();
    }

    public void increment(Long id, int quantityBooks) throws PersonNotFoundException{
        Person personBeforeIncrement = verifyIfExists(id);

        if (personBeforeIncrement.getQuantityBooks() < quantityBooks ||personBeforeIncrement.getQuantityBooks() > quantityBooks){

            personBeforeIncrement.setQuantityBooks(quantityBooks);
            personRepository.save(personBeforeIncrement);
        }
    }
       
    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
