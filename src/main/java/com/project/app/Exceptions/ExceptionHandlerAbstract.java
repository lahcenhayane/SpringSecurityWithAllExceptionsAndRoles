/**
 * 
 */
package com.project.app.Exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */


public abstract class ExceptionHandlerAbstract extends RuntimeException {

	public ExceptionHandlerAbstract(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public abstract HttpStatus getStatuCode();
	
	
}
