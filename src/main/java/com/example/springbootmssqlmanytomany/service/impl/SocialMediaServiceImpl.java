package com.example.springbootmssqlmanytomany.service.impl;

import com.example.springbootmssqlmanytomany.dto.SocialMediaAppDTO;
import com.example.springbootmssqlmanytomany.exception.SocialMediaAlreadyException;
import com.example.springbootmssqlmanytomany.mapper.SocialMediaAppMapper;
import com.example.springbootmssqlmanytomany.model.Person;
import com.example.springbootmssqlmanytomany.model.SocialMediaApp;
import com.example.springbootmssqlmanytomany.repository.SocialMediaAppRepository;
import com.example.springbootmssqlmanytomany.service.SocialMediaService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SocialMediaServiceImpl implements SocialMediaService {

    final SocialMediaAppRepository socialMediaAppRepository;
    final SocialMediaAppMapper socialMediaAppMapper;

    @Override
    public SocialMediaApp saveSocialMediaApp(SocialMediaAppDTO socialMediaAppDTO) {
        SocialMediaApp socialMediaApp=socialMediaAppMapper.socialMediaAppDTOtoSocialMediaApp(socialMediaAppDTO);
        if (socialMediaAppRepository.existsSocialMediaAppByName(socialMediaAppDTO.getName())){
            throw new SocialMediaAlreadyException();
        }
        return socialMediaAppRepository.save(socialMediaApp);
    }

    @Override
    public void deleteSocialMediaApp(long id) {
            socialMediaAppRepository.deleteById(id);
    }

    @Override
    public List<SocialMediaApp> getAllSocialMediaApps() {
        return socialMediaAppRepository.findAll();
    }

    @Override
    public SocialMediaApp getSocialMediaWithName(String name) {
        return socialMediaAppRepository.findSocialMediaAppByName(name);
    }
}
