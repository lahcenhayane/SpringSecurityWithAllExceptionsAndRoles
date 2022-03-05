/**
 * 
 */
package com.project.app.Services.Impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.app.DTOs.UserDto;
import com.project.app.Exceptions.NotFoundException;
import com.project.app.Models.Role;
import com.project.app.Models.User;
import com.project.app.Repositories.UserRepository;
import com.project.app.Services.IUserService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) throw new NotFoundException("User not found."); 
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user.getRoles()));
	}

	/**
	 * @param roles
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(roles.size());
		roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase())));
		return authorities;
	}

	@Override
	public boolean findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			return false; 
		}
		return true;
	}
	
	

}
