/**
 * 
 */
package com.project.app.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.app.DTOs.UserDto;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface IUserService extends UserDetailsService {

	/**
	 * @param email
	 * @return
	 */
	boolean findByEmail(String email);

}
