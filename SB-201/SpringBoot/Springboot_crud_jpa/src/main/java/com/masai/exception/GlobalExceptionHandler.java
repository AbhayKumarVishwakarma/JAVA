package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(StudentException se, WebRequest wr){
		MyErrorDetails details = new MyErrorDetails();
		details.setLdt(LocalDateTime.now());
		details.setMsg(se.getMessage());
		details.setDetails(wr.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	//to handler any generic type exception
		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> exceptionHandler2(Exception se, WebRequest wr){
			MyErrorDetails details = new MyErrorDetails();
			details.setLdt(LocalDateTime.now());
			details.setMsg(se.getMessage());
			details.setDetails(wr.getDescription(false));
			return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
		}
}
