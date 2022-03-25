package com.example.springbootmssqlmanytomany.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SocialMediaResponse {


    long id;

    String name;

}
