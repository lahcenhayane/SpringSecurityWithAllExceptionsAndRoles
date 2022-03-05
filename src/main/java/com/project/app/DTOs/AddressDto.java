/**
 * 
 */
package com.project.app.DTOs;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
	
	private String address1;
	private String address2;
	private String pays;
	private String city;
	private String zipCode;
	
}
