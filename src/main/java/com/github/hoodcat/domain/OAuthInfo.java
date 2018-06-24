package com.github.hoodcat.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class OAuthInfo {
    @Value("${com.cafe24.oauth.client-id}")
    private String clientId;
    @Value("${com.cafe24.oauth.client-secret}")
    private String clientSecret;
    @Value("${com.cafe24.oauth.authentication-url}")
    private String authURL;
    @Value("${com.cafe24.oauth.token-gen-url}")
    private String tokenGenURL;
    @Value("${com.cafe24.oauth.redirect-url}")
    private String redirectURL;
    @Value("${com.cafe24.oauth.scope}")
    private String scope;
    @Value("${com.cafe24.oauth.response_type}")
    private String respType;
    @Value("${com.cafe24.oauth.state}")
    private String state;
    private String code;

    public String getAuthCodeURL() {
        return this.getAuthCodeURL("hoodcat123");
    }

    public String getAuthCodeURL(String mallId) {
        String url = String.format(
                "%s?response_type=%s&" + "client_id=%s&" + "state=%s&"
                        + "redirect_uri=%s&" + "scope=%s",
                authURL, respType, clientId, state, redirectURL, scope);
        return url.replace("{{mallid}}", mallId);
    }
}
