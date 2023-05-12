package com.masai.exception;

public class MethodArgumentNotValidException extends Exception{
    public MethodArgumentNotValidException() {
    }

    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
