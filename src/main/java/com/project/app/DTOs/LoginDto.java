/**
 * 
 */
package com.project.app.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
	
	private String email;
	private String password;

}
