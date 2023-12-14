package com.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JwtToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String jwtToken;
	private LocalDate date;

	public JwtToken() {
		super();
	}

	public JwtToken(String username, String jwtToken, LocalDate date) {
		super();
		this.username = username;
		this.jwtToken = jwtToken;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "JwtToken [id=" + id + ", username=" + username + ", jwtToken=" + jwtToken + ", date=" + date + "]";
	}

}
