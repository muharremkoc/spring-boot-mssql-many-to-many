package com.example.springbootmssqlmanytomany.service.impl;

import com.example.springbootmssqlmanytomany.dto.PersonDTO;
import com.example.springbootmssqlmanytomany.mapper.PersonMapper;
import com.example.springbootmssqlmanytomany.mapper.SocialMediaAppMapper;
import com.example.springbootmssqlmanytomany.model.Person;
import com.example.springbootmssqlmanytomany.model.SocialMediaApp;
import com.example.springbootmssqlmanytomany.repository.PersonRepository;
import com.example.springbootmssqlmanytomany.repository.SocialMediaAppRepository;
import com.example.springbootmssqlmanytomany.service.PersonService;
import com.example.springbootmssqlmanytomany.service.SocialMediaService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;
    final SocialMediaService socialMediaService;
    final PersonMapper personMapper;
    final SocialMediaAppMapper socialMediaAppMapper;

    @Override
    public Person savePerson(PersonDTO personDTO) {

        Person person=personMapper.personDTOtoPerson(personDTO);

         personDTO.getSocialMediaAppDTO().stream().forEach(socialMediaAppDTO -> {
             SocialMediaApp socialMediaApp=socialMediaService.getSocialMediaWithName(socialMediaAppDTO.getName());
             socialMediaApp.addPerson(person);
         });
         return personRepository.save(person);
    }

    @Override
    public void deletePerson(long id) {
             personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
