package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	// add an excpetion handler for emp not found exception
	
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e)
	{
		// create emp error respose
		
		EmployeeErrorResponse error=new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value()
				,e.getMessage(),System.currentTimeMillis());
		
		// return response entity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// add another exception to catch any other exception
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception e)
	{
		// create emp error respose
		
		EmployeeErrorResponse error=new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value()
				,e.getMessage(),System.currentTimeMillis());
		
		// return response entity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
