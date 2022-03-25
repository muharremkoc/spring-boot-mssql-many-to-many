package com.example.springbootmssqlmanytomany.repository;

import com.example.springbootmssqlmanytomany.model.SocialMediaApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaAppRepository extends JpaRepository<SocialMediaApp,Long> {

    SocialMediaApp findSocialMediaAppByName(String name);

    boolean existsSocialMediaAppByName(String name);

}
