package com.user.uitil;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).signWith(SECRET_KEY).compact();
    }

    public String extractUsername(String token) {
    	
    	try {
    		Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return claims.getSubject();
    	} catch(Exception ex) {
    		System.out.println("Passed Invalid Token");
    		return null;
    	}
        
    }


	
}
