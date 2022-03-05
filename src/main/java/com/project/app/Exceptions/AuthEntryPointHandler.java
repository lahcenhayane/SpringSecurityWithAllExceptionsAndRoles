/**
 * 
 */
package com.project.app.Exceptions;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
@Component
public class AuthEntryPointHandler implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException ex) throws IOException, ServletException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		
		ExceptionDetails exceptionDetails = ExceptionDetails.builder()
				.message(ex.getMessage())
				.status(HttpStatus.UNAUTHORIZED.value())
				.timetamps(new Date())
				.build();
		
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, exceptionDetails);
		out.flush();
		
	}

}
