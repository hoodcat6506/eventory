package com.github.hoodcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.hoodcat.service.OAuthService;

@Controller
@RequestMapping("oauth")
public class OAuthController {
    @Autowired
    private OAuthService oauthService;

    @GetMapping("")
    public String reqAuthCode() {
        return "redirect:" + oauthService.getAuthCodeURL();
    }

    @GetMapping("code")
    public String procAuthCode(@RequestParam(value = "code", required = false, defaultValue = "is Empty") String code) {
        oauthService.setCode(code);
        return "redirect:/oauth/token";
    }
    
    @GetMapping("token")
    public String procAuthToken() {
        oauthService.genAccessToken();
        return "redirect:/";
    }
}
