package com.github.hoodcat.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hoodcat.domain.OAuthInfo;
import com.github.hoodcat.util.Base64EDecoder;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class OAuthService {
    @Autowired
    private OAuthInfo oauthInfo;

    public void genAccessToken() {
        String encodedID = Base64EDecoder.encode(oauthInfo.getClientId() + ":" + oauthInfo.getClientSecret());
        OkHttpClient client = new OkHttpClient.Builder().followRedirects(true).build();
        
        RequestBody parameter = new FormBody.Builder()
                .add("grant_type", "authorization_code")
                .add("code", oauthInfo.getCode())
                .add("redirect_uri", oauthInfo.getRedirectURL())
                .build();
        
        Request request = new Request.Builder()
                .url(oauthInfo.getTokenGenURL())
                .addHeader("Authorization", "Basic " + encodedID)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(parameter)
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getAuthCodeURL() {
        return oauthInfo.getAuthCodeURL();
    }

    public void setCode(String code) {
        oauthInfo.setCode(code);
    }
}
