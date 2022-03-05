package com.project.app.Exceptions;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */
public class AccessDeniedExceptionHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException ex) throws IOException, ServletException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpStatus.FORBIDDEN.value());
		
		ExceptionDetails exceptionDetails = ExceptionDetails.builder()
							.message(ex.getMessage())
							.status(HttpStatus.FORBIDDEN.value())
							.timetamps(new Date())
							.build();
		
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, exceptionDetails);
		out.flush();
		
	}

}
