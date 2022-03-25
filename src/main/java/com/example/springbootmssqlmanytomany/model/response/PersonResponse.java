package com.example.springbootmssqlmanytomany.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonResponse {

    long id;

    String firstName;

    String userName;

    List<SocialMediaResponse> socialMediaResponseList;
}
