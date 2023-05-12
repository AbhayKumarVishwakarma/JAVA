package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvaildRollNumberException.class)
    public ResponseEntity<String> myExHandler(InvaildRollNumberException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myExHandler2(Exception e, WebRequest wbr){
        MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wbr.getDescription(false));
        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
