package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CompanyException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler1(CompanyException se, WebRequest wr){
        MyErrorDetails details = new MyErrorDetails();
        details.setLdt(LocalDateTime.now());
        details.setMsg(se.getMessage());
        details.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ModalException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler2(ModalException se, WebRequest wr){
        MyErrorDetails details = new MyErrorDetails();
        details.setLdt(LocalDateTime.now());
        details.setMsg(se.getMessage());
        details.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler3(CarException se, WebRequest wr){
        MyErrorDetails details = new MyErrorDetails();
        details.setLdt(LocalDateTime.now());
        details.setMsg(se.getMessage());
        details.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MechanicException.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler4(MechanicException se, WebRequest wr){
        MyErrorDetails details = new MyErrorDetails();
        details.setLdt(LocalDateTime.now());
        details.setMsg(se.getMessage());
        details.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }


    /**
     * use to handler any generic type exception
     * @param se
     * @param wr
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandler(Exception se, WebRequest wr){
        MyErrorDetails details = new MyErrorDetails();
        details.setLdt(LocalDateTime.now());
        details.setMsg(se.getMessage());
        details.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
