package com.github.hoodcat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hoodcat.domain.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

}
