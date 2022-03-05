/**
 * 
 */
package com.project.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.Services.IUserService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping
	public String get() {
		return "GET User";
	}
	
	@PostMapping
	public String post() {
		return "POST User";
	}
	
	
	@PutMapping
	public String put() {
		return "PUT User";
	}
	
	
	@DeleteMapping
	public String delete() {
		return "DELETE User";
	}
	
	
}
