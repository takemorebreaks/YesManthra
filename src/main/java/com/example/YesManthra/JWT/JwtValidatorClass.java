package com.example.YesManthra.JWT;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.YesManthra.Constants.StringConstantClass;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidatorClass extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	String jwt = request.getHeader(StringConstantClass.JwtHeader);
	if(jwt!=null)
	{
		jwt=jwt.substring(9);
		try {
			SecretKey key = Keys.hmacShaKeyFor(StringConstantClass.JwtTokenSecret_KEY.getBytes());
			Claims claims =Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
			String email = String.valueOf(claims.get("email"));
			String authorities=String.valueOf(claims.get("authorities"));
			List<GrantedAuthority>auth=AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
			Authentication authentication = new UsernamePasswordAuthenticationToken(email,null ,auth);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		catch (Exception e) {
			throw new BadCredentialsException("Invalide token from jwt Validator");
		}
			
		}
	filterChain.doFilter(request, response);
	}
	}


