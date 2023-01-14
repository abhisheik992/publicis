package com.publicis.poc.errorhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessaage> handleExceptions(Exception e) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		return new ResponseEntity<>(new ErrorMessaage(new Date(), 404, status.toString(), e.getMessage().toString(), e.getStackTrace().toString()), status);
	}
}
