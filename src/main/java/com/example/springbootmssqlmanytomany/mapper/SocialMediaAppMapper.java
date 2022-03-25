package com.example.springbootmssqlmanytomany.mapper;

import com.example.springbootmssqlmanytomany.dto.SocialMediaAppDTO;
import com.example.springbootmssqlmanytomany.model.SocialMediaApp;
import com.example.springbootmssqlmanytomany.model.response.SocialMediaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper
public interface SocialMediaAppMapper {

    SocialMediaApp socialMediaAppDTOtoSocialMediaApp(SocialMediaAppDTO socialMediaAppDTO);

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "name",source = "name")
    })
    SocialMediaResponse socialMediaToSocialMediaResponse(SocialMediaApp socialMediaApp);

    @Mappings({

        @Mapping(target = "id",source = "id"),
       @Mapping(target = "name",source = "name")
    })
    List<SocialMediaResponse> socialMediaListToSocialMediaResponseList(List<SocialMediaApp> socialMediaApp);

    @Mappings({
            @Mapping(target = "name",source = "name")
    })
    SocialMediaResponse socialMediaDtoToSocialMediaResponse(SocialMediaAppDTO socialMediaAppDTO);

}
