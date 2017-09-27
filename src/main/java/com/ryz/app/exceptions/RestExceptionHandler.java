package com.ryz.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ryz.app.exceptions.Error;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Error> handelValidationErrors(MethodArgumentNotValidException ex) {
		Error error = new Error();
		error.setErrorCount(ex.getBindingResult().getAllErrors().size());
		for (ObjectError e : ex.getBindingResult().getAllErrors()) {
			error.getMessages().add(e.getDefaultMessage());
		}

		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<Error> handelNotFoundException(NotFoundException ne) {

		Error er = new Error();
		er.setErrorCount(1);
		er.getMessages().add(ne.getMessage());

		return new ResponseEntity<Error>(er, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<Error>handelInternalServerError(Exception ie){
		Error er = new Error();
		er.setErrorCount(1);
		er.getMessages().add(ie.getMessage());
		
		return new ResponseEntity<Error>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}