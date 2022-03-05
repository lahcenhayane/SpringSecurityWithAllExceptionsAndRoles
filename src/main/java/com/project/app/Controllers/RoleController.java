/**
 * 
 */
package com.project.app.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.Services.IRoleService;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@RestController
@RequestMapping("roles")
public class RoleController {

	private IRoleService roleService;
	
	@GetMapping
	public String get() {
		return "Get Role";
	}
	
	@PostMapping
	public String post() {
		return "POST Role";
	}
	
	@DeleteMapping
	public String Delete() {
		return "DELETE Role";
	}
	
	@PutMapping
	public String put() {
		return "PUT Role";
	}
}
