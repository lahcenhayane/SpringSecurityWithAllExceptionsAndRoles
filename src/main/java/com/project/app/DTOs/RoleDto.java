/**
 * 
 */
package com.project.app.DTOs;

import java.util.Date;
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
public class RoleDto {
	
	private long id;
	private String name;

}
