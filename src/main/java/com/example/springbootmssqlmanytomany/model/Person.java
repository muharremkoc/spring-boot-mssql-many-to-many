package com.example.springbootmssqlmanytomany.model;

import com.example.springbootmssqlmanytomany.dto.SocialMediaAppDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String firstName;

    String userName;


    @ManyToMany(mappedBy = "personList", cascade = CascadeType.ALL)
    @JsonIgnore
    List<SocialMediaApp> socialMediaApp=new ArrayList<>();

    public void addSocialMediaApp(SocialMediaApp socialMediaApp){
        this.socialMediaApp.add(socialMediaApp);
        this.getSocialMediaApp().stream().forEach(socialMediaApp1 -> socialMediaApp1.setPersonList(Arrays.asList(this)));
    }
}