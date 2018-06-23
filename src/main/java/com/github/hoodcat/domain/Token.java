package com.github.hoodcat.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Token {
    private Long no;
    private String accessToken;
    private String refreshToken;
    private Date issueDate;
    private Date expireDate;
}
