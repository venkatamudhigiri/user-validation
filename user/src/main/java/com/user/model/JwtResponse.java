package com.user.model;

public final class JwtResponse {
	private String key;
	private String value;
	
	public JwtResponse(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
}
