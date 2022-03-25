package com.example.springbootmssqlmanytomany.dto;

import com.example.springbootmssqlmanytomany.model.SocialMediaApp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class PersonDTO {

     String firstName;

     String userName;

     List<SocialMediaAppDTO> socialMediaAppDTO;
}
