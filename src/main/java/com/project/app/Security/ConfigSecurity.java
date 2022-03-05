/**
 * 
 */
package com.project.app.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import com.project.app.Exceptions.AccessDeniedExceptionHandler;
import com.project.app.Exceptions.AuthEntryPointHandler;
import com.project.app.Services.IUserService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthEntryPointHandler authEntryPointHandler;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.authorizeRequests().antMatchers("/roles").hasAuthority("ADMIN")
								.antMatchers("/users").hasAuthority("CLIENT")
								.antMatchers(HttpMethod.POST, "/users").permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().accessDeniedHandler(new AccessDeniedExceptionHandler())
								.authenticationEntryPoint(new AuthEntryPointHandler())
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new JwtAuthenticationFilter(authenticationManager(), userService, authEntryPointHandler))
			.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
	
}
