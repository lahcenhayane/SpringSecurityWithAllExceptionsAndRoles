/**
 * 
 */
package com.project.app.DTOs;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private long id;
	private String name;
	private AddressDto addressdto;
	private String email;
	private String password;
	private String birthDay;
	private Set<RoleDto> roles = new HashSet<RoleDto>();

}
