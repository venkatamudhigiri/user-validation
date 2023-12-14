package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.JwtToken;
import com.user.repository.JwtTokenRepository;

@Service
public class JwtTokenServiceImpl implements JwtTokenService{

	@Autowired
	JwtTokenRepository jwtTokensRepository;
	
	public void saveToken(JwtToken jwtToken) {
		jwtTokensRepository.save(jwtToken);
	}
	
	public JwtToken findByUsername(String userName) {
		Optional<JwtToken> jwtToken = jwtTokensRepository.findByUsername(userName);
		
		if(jwtToken.isPresent())
			return jwtToken.get();
		return null;
	}
}
