/**
 * 
 */
package com.project.app.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "roles")
public class Role extends AbstractModel {

	@Column(length = 10, nullable = false, unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.REMOVE)
	private List<User> users;
	
}
