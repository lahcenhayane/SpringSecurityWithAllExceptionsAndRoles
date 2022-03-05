/**
 * 
 */
package com.project.app.Mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.app.DTOs.UserDto;
import com.project.app.Models.User;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "addressdto", source = "address")
	@Mapping(target = "birthDay", dateFormat = "yyyy-MM-dd")
	@Mapping(target = "password", ignore = true)
	UserDto map(User user);
	
	@InheritInverseConfiguration
	User map(UserDto userDto);
	
}
