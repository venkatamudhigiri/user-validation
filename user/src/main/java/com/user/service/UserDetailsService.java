package com.user.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.user.entity.UserDetails;

public interface UserDetailsService {

	UserDetails getUserByUsername(String username) throws UsernameNotFoundException ;
	void save(UserDetails UserDetails);
}
