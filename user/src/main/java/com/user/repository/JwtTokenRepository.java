package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.JwtToken;

public interface JwtTokenRepository extends JpaRepository<JwtToken, Long> {
	Optional<JwtToken> findByUsername(String username);
}
