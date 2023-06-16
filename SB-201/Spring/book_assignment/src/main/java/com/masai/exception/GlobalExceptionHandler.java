package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ce.getMessage());
        err.setDetails(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler2(BookException m, WebRequest w){
        MyErrorDetails details = new MyErrorDetails();
        details.setTime(LocalDateTime.now());
        details.setMessage(m.getMessage());
        details.setDetails(w.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler3(Exception m, WebRequest w){
        MyErrorDetails details = new MyErrorDetails();
        details.setTime(LocalDateTime.now());
        details.setMessage(m.getMessage());
        details.setDetails(w.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
