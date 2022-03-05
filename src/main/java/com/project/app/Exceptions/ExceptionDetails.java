/**
 * 
 */
package com.project.app.Exceptions;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lahcen HAYANE
 * @email lahcenhayane@gmail.com
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionDetails {

	private String message;
	private int status;
	private String path;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date timetamps;
	
}
