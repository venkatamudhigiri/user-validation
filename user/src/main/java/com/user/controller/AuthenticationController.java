package com.user.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.JwtToken;
import com.user.entity.UserDetails;
import com.user.exception.InvalidCredentialsException;
import com.user.exception.UserDetailsNotFoundException;
import com.user.model.JwtRequest;
import com.user.model.JwtResponse;
import com.user.service.JwtTokenServiceImpl;
import com.user.service.RequestValidateService;
import com.user.service.UserDetailsService;
import com.user.uitil.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private RequestValidateService requestValidateService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	JwtTokenServiceImpl jwtTokenService;

	@PostMapping("/save")
	public ResponseEntity<?> saveUserDetails(@RequestBody UserDetails userDetails) {
		userDetailsService.save(userDetails);
		return ResponseEntity.ok("UserDetails Saved Successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<Object> createAuthenticationToken(@RequestBody JwtRequest request) throws Exception {

		final UserDetails userDetails = userDetailsService.getUserByUsername(request.getUsername());

		if (userDetails != null) {
			if (requestValidateService.validateRequest(request, userDetails)) {
				final String token = jwtTokenUtil.generateToken(userDetails.getUsername());

				LocalDate date = LocalDate.now();
				JwtToken jwtToken = new JwtToken(request.getUsername(), token, date);

				// saving the token into database
				jwtTokenService.saveToken(jwtToken);

				return ResponseEntity.ok(new JwtResponse("JwtToken", token));
			} else {
				throw new InvalidCredentialsException("Invalid Username and Password");
			}
		}
		throw new UserDetailsNotFoundException("User Details Not Found for this User: " + request.getUsername());
	}

}