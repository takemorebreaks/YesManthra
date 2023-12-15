package com.example.YesManthra.JWT;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.YesManthra.Constants.StringConstantClass;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProviderClass {
	SecretKey key = Keys.hmacShaKeyFor(StringConstantClass.JwtTokenSecret_KEY.getBytes());
public String GenerateJwtToken(Authentication auth)
{
	String jwt = Jwts.builder()
			.setIssuedAt(new Date())
			.setExpiration(new Date(new Date().getTime()+846000000))
			.claim("email", auth.getName())
			.signWith(key).compact();
	return jwt;
	
}
public String getEmailFromToken(String jwt)
{
	jwt=jwt.substring(9);
	Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
	String email=String.valueOf(claims.get("email"));
	return email;
	
}
}
