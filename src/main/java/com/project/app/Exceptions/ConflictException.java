/**
 * 
 */
package com.project.app.Exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public class ConflictException extends ExceptionHandlerAbstract{

	/**
	 * @param message
	 */
	public ConflictException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getStatuCode() {
		// TODO Auto-generated method stub
		return HttpStatus.CONFLICT;
	}

}
