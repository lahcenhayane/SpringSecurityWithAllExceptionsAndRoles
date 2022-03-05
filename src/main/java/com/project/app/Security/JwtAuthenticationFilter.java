/**
 * 
 */
package com.project.app.Security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.app.DTOs.LoginDto;
import com.project.app.DTOs.UserDto;
import com.project.app.Exceptions.AuthEntryPointHandler;
import com.project.app.Models.User;
import com.project.app.Services.IUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private IUserService userService;
	private AuthEntryPointHandler authEntryPointHandler;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, IUserService userService, AuthEntryPointHandler authEntryPointHandler) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.authEntryPointHandler = authEntryPointHandler;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			LoginDto login = new ObjectMapper().readValue(request.getInputStream(), LoginDto.class);
			
			if (!userService.findByEmail(login.getEmail())) {
				AuthenticationException ex = new BadCredentialsException("Email or password is not correct.");
				authEntryPointHandler.commence(request, response, ex);
				return null;
			}
			
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
			return authenticationManager.authenticate(authentication);
		} catch (IOException | ServletException e) {
			
			throw new RuntimeException(e.getMessage());
			
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("roles", auth.getAuthorities());
		
		String token = Jwts.builder()
							.setSubject(auth.getName())
							.setClaims(claims)
							.setExpiration(new Date(System.currentTimeMillis() + ConstSecurity.EXPERATION_DATE_TOKEN))
							.signWith(SignatureAlgorithm.HS256, ConstSecurity.SECRET_TOKEN)
							.compact();
		
		response.setContentType("application/json");
		response.addHeader(ConstSecurity.HEADER_TOKEN, ConstSecurity.PREFIX_TOKEN+token);
		
	}
	

}
