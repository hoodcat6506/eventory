package com.github.hoodcat.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.hoodcat.domain.OAuthInfo;

@RestController(value="oauthRest")
public class OAuthController {
    @Autowired
    private OAuthInfo oauthInfo;
    
    @GetMapping("rest")
    public OAuthInfo getOAuthInfo() { 
        return oauthInfo;
    }
}
