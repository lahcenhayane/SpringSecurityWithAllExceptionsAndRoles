/**
 * 
 */
package com.project.app.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.Repositories.RoleRepository;
import com.project.app.Services.IRoleService;

/**
 * @author Lahcen HAYANE
 * @email lahc

import org.springframework.stereotype.Service;enhayane@gmail.com
 */

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
}
