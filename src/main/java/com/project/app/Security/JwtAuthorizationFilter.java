/**
 * 
 */
package com.project.app.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	/**
	 * @param authenticationManager
	 */
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String token = request.getHeader(ConstSecurity.HEADER_TOKEN);
		
		if (token == null || !token.startsWith(ConstSecurity.PREFIX_TOKEN)) {
			chain.doFilter(request, response);
			return;
		}
		
		token = token.replace(ConstSecurity.PREFIX_TOKEN, "");
		
		Claims data = Jwts.parser()
						  .setSigningKey(ConstSecurity.SECRET_TOKEN)
						  .parseClaimsJws(token)
						  .getBody();
		
			
		List<Map<String, Object>> claims = (List<Map<String, Object>>) data.get("roles");
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		claims.stream().forEach(role->authorities.add(new SimpleGrantedAuthority(role.get("authority").toString())));
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(data.getSubject(), null, authorities);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		chain.doFilter(request, response);
		
	}

}
