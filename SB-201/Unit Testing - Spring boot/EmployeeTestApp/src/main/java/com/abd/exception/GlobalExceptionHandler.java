package com.abd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * To handle employee exception
     * @param ex
     * @param wb
     * @return error details in response entity
     */
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<MyErrorDetails> employeeExceptionHandler(EmployeeException ex, WebRequest wb){

        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> argumentExceptionHandler(MethodArgumentNotValidException ex){

        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage("Validation error!");
        err.setDetails(ex.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception ex, WebRequest wb){

        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ex.getMessage());
        err.setDetails(wb.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
