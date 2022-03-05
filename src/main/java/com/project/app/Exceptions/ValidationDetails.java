/**
 * 
 */
package com.project.app.Exceptions;

import java.util.Date;
import java.util.Map;

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
public class ValidationDetails {
	
	private Map<String, String> erros;
	private int status;
	private String path;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date timetamps;

}
