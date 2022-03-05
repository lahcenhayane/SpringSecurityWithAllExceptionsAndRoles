/**
 * 
 */
package com.project.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.Models.Role;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	/**
	 * @param string
	 * @return
	 */
	Role findByName(String string);

}
