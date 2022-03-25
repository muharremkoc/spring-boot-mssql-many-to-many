package com.example.springbootmssqlmanytomany.controller;

import com.example.springbootmssqlmanytomany.dto.PersonDTO;
import com.example.springbootmssqlmanytomany.dto.SocialMediaAppDTO;
import com.example.springbootmssqlmanytomany.model.Person;
import com.example.springbootmssqlmanytomany.model.SocialMediaApp;
import com.example.springbootmssqlmanytomany.service.SocialMediaService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/relation/socialMedias")
public class SocialMediaController {

    final SocialMediaService socialMediaService;

    @PostMapping("/socialMedia")
    public SocialMediaApp saveSocialMediaApp(@RequestBody SocialMediaAppDTO socialMediaAppDTO){
        return socialMediaService.saveSocialMediaApp(socialMediaAppDTO);
    }

    @GetMapping("/socialMedia")
    public List<SocialMediaApp> socialMediaAppList(){
        return socialMediaService.getAllSocialMediaApps();
    }

    @DeleteMapping("/socialMedia/{id}")
    public void socialMediaAppDelete(@PathVariable("id") long id){
        socialMediaService.deleteSocialMediaApp(id);
    }


    @GetMapping("/socialMedia/{name}")
    public SocialMediaApp getSocialMediaApp(@PathVariable("name") String name){
        return socialMediaService.getSocialMediaWithName(name);
    }
}
