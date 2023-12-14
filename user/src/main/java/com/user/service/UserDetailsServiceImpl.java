package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.entity.UserDetails;
import com.user.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDetailsRepository userRepository;

	@Override
	public UserDetails getUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDetails> user = userRepository.findByUsername(username);

		if (user.isPresent())
			return user.get();

		return null;
	}

	public void save(UserDetails userDetails) {
		userRepository.save(userDetails);
	}
}
