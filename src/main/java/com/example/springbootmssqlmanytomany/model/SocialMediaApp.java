package com.example.springbootmssqlmanytomany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "social_media_app")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SocialMediaApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JsonIgnore
    @JoinTable(name = "social_media_persons",
            joinColumns = {
                    @JoinColumn(name = "social_media_id", referencedColumnName = "id",
                            nullable = true, updatable = true)},
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id",
                            nullable = true, updatable = true)})
    List<Person> personList=new ArrayList<>();

    public void addPerson(Person person) {
       this.personList.add(person);
       this.getPersonList().stream().forEach(person1 -> person1.setSocialMediaApp(Arrays.asList(this)));
    }

}
