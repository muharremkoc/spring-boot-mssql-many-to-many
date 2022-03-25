package com.example.springbootmssqlmanytomany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SocialMediaAlreadyException extends RuntimeException{
    @Override
    public String getMessage() {

        return super.getMessage();
    }

}
