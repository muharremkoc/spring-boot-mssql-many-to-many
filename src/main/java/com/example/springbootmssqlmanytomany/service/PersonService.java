package com.example.springbootmssqlmanytomany.service;

import com.example.springbootmssqlmanytomany.dto.PersonDTO;
import com.example.springbootmssqlmanytomany.model.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(PersonDTO personDTO);
    void deletePerson(long id);
    List<Person> getAllPersons();
}
