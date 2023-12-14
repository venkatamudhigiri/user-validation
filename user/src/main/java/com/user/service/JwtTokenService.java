package com.user.service;

import com.user.entity.JwtToken;

public interface JwtTokenService {

	void saveToken(JwtToken jwtToken);

	JwtToken findByUsername(String userName);
}
