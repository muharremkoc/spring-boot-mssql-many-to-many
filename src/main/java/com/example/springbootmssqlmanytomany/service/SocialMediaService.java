package com.example.springbootmssqlmanytomany.service;

import com.example.springbootmssqlmanytomany.dto.SocialMediaAppDTO;
import com.example.springbootmssqlmanytomany.model.SocialMediaApp;

import java.util.List;

public interface SocialMediaService {

    SocialMediaApp saveSocialMediaApp(SocialMediaAppDTO socialMediaAppDTO);
    void  deleteSocialMediaApp(long id);
    List<SocialMediaApp> getAllSocialMediaApps();
    SocialMediaApp getSocialMediaWithName(String name);

}
