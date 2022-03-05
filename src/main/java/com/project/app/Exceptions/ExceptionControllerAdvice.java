/**
 * 
 */
package com.project.app.Exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ExceptionHandlerAbstract.class)
	public ResponseEntity<ExceptionDetails> getExceptionHandler(ExceptionHandlerAbstract ex, WebRequest webRequest){
		
		ExceptionDetails exceptionDetails = ExceptionDetails.builder()
							.message(ex.getMessage())
							.path(webRequest.getDescription(false))
							.status(ex.getStatuCode().value())
							.timetamps(new Date())
							.build();
		
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, ex.getStatuCode());
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<String, String>();
		ex.getFieldErrors().stream().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		
		ValidationDetails validationDetails = ValidationDetails.builder()
							.timetamps(new Date())
							.path(request.getDescription(false))
							.status(status.value())
							.erros(errors)
							.build();
		
		return new ResponseEntity<Object>(validationDetails, status);
	}
	
}
