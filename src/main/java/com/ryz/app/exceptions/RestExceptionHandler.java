package com.ryz.app.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	static Logger logger = Logger.getLogger(RestExceptionHandler.class);

	@ExceptionHandler
	public ResponseEntity<Error> handelValidationErrors(MethodArgumentNotValidException ex) {
		Error error = new Error();
		error.setErrorCount(ex.getBindingResult().getAllErrors().size());
		for (ObjectError e : ex.getBindingResult().getAllErrors()) {
			error.getMessages().add(e.getDefaultMessage());
			logger.info("Error Message:"+" "+ e.getDefaultMessage());
		}

		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<Error> handelNotFoundException(NotFoundException ne) {

		Error er = new Error();
		er.setErrorCount(1);
		er.getMessages().add(ne.getMessage());
		logger.info("Error Message:"+" "+ er.getMessages());
		return new ResponseEntity<Error>(er, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<Error>handelInternalServerError(Exception ie){
		Error er = new Error();
		er.setErrorCount(1);
		er.getMessages().add(ie.getMessage());
		logger.info("Error Message:"+" "+ er.getMessages());
		
		return new ResponseEntity<Error>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}