package com.example.springbootmssqlmanytomany.mapper;

import com.example.springbootmssqlmanytomany.dto.PersonDTO;
import com.example.springbootmssqlmanytomany.model.Person;
import com.example.springbootmssqlmanytomany.model.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Mappings({
      @Mapping(target = "firstName",source = "firstName"),
      @Mapping(target = "userName",source = "userName"),
      @Mapping(target = "socialMediaApp",source = "socialMediaAppDTO")
    })
    Person personDTOtoPerson(PersonDTO personDTO);

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "firstName",source = "firstName"),
            @Mapping(target = "userName",source = "userName"),
    })
    PersonResponse personToPersonResponse(Person person);

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "firstName",source = "firstName"),
            @Mapping(target = "userName",source = "userName"),
            @Mapping(target = "socialMediaResponseList.id",source = "socialMediaApp.id"),
            @Mapping(target = "socialMediaResponseList.name",source = "socialMediaApp.name")

    })
    List<PersonResponse> personListToPersonResponse(List<Person> personList);

    PersonResponse personDTOtoPersonResponse(PersonDTO personDTO);

}
