package com.abd.exception;

public class EmployeeException extends RuntimeException{
    public EmployeeException() {
    }

    public EmployeeException(String message) {
        super(message);
    }
}
