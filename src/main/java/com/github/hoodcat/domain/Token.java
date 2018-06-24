package com.github.hoodcat.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity(name = "token")
@Table(name = "token")
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   no;
    @Column(name = "mall_id")
    private String mallId;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "refresh_token")
    private String refreshToken;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "issued_date")
    private Date   issuedDate;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "expire_date")
    private Date   expireDate;
}
