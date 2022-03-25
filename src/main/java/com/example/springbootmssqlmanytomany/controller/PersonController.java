package com.example.springbootmssqlmanytomany.controller;

import com.example.springbootmssqlmanytomany.dto.PersonDTO;
import com.example.springbootmssqlmanytomany.mapper.PersonMapper;
import com.example.springbootmssqlmanytomany.mapper.SocialMediaAppMapper;
import com.example.springbootmssqlmanytomany.model.Person;
import com.example.springbootmssqlmanytomany.model.response.PersonResponse;
import com.example.springbootmssqlmanytomany.service.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/relation/persons")
public class PersonController {

    final PersonService personService;
    final PersonMapper personMapper;
    final SocialMediaAppMapper socialMediaAppMapper;

    @PostMapping("/person")
    public PersonResponse savePerson(@RequestBody PersonDTO personDTO){
        Person person=personService.savePerson(personDTO);
        PersonResponse personResponse=personMapper.personToPersonResponse(person);
        personResponse.setSocialMediaResponseList(socialMediaAppMapper.socialMediaListToSocialMediaResponseList(person.getSocialMediaApp()));
        return personResponse;
    }

    @GetMapping("/person")
    public List<PersonResponse> personList(){
             List<Person> personList=personService.getAllPersons();
             personList.stream().map(person -> personMapper.personToPersonResponse(person)).collect(Collectors.toList());
           /*
             personList.stream().forEach(person -> {
                 PersonResponse personResponse=personMapper.personToPersonResponse(person);
                 personResponse.setSocialMediaResponseList(socialMediaAppMapper.socialMediaListToSocialMediaResponseList(person.getSocialMediaApp()));
             });

            */
        List<PersonResponse> personResponseList=personMapper.personListToPersonResponse(personList);
        return personResponseList;
    }

    @DeleteMapping("/person/{id}")
    public void personDelete(@PathVariable("id") long id){
        personService.deletePerson(id);
    }



}
