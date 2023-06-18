package com.masai.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
