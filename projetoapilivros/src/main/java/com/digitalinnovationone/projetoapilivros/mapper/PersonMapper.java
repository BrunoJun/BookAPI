package com.digitalinnovationone.projetoapilivros.mapper;

import com.digitalinnovationone.projetoapilivros.dto.request.PersonDTO;
import com.digitalinnovationone.projetoapilivros.entity.Person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);

    PersonDTO toPerson(Person person);
}
