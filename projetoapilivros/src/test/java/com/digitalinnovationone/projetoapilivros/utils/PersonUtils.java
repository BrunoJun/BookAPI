package com.digitalinnovationone.projetoapilivros.utils;

import java.util.Collections;

import com.digitalinnovationone.projetoapilivros.dto.request.PersonDTO;
import com.digitalinnovationone.projetoapilivros.entity.Person;

public class PersonUtils{

    private static final String FIRST_NAME = "Bruno Jun";
    private static final String LAST_NAME = "Amanai Yamada";
    private static final String CPF_NUMBER = "000.000.000-00";
    private static final Integer QUANTITY_BOOKS = 4;
    private static final long PERSON_ID = 1l;


    public static PersonDTO createFakeDTO(){

        return PersonDTO.builder()
        .firstName(FIRST_NAME)
        .lastName(LAST_NAME)
        .cpf(CPF_NUMBER)
        .quantityBooks(QUANTITY_BOOKS)
        .id(PERSON_ID)
        .books(Collections.singletonList(BookUtils.createFakeDTO()))
        .build();
    }

    public static Person createFakeEntity(){

        return Person.builder()
        .firstName(FIRST_NAME)
        .lastName(LAST_NAME)
        .cpf(CPF_NUMBER)
        .quantityBooks(QUANTITY_BOOKS)
        .books(Collections.singletonList(BookUtils.createFakeEntity()))
        .id(PERSON_ID)
        .build();
    }
}
