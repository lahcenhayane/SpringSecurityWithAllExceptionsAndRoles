/**
 * 
 */
package com.project.app.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.project.app.DTOs.AddressDto;

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
@Embeddable
public class Address {

	@Column(length = 250, nullable = false)
	private String address1;
	
	@Column(length = 250, nullable = true)
	private String address2;
	
	@Column(length = 20, nullable = false)
	private String pays;
	
	@Column(length = 20, nullable = false)
	private String city;
	
	@Column(length = 10, nullable = false)
	private String zipCode;
	
	
}
