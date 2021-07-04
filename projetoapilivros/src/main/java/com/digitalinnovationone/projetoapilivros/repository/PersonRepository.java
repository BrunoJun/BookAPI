package com.digitalinnovationone.projetoapilivros.repository;

import com.digitalinnovationone.projetoapilivros.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
    
}
