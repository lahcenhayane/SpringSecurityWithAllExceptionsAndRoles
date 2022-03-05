/**
 * 
 */
package com.project.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.Models.User;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

}
