package com.abd.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyErrorDetails {
    private LocalDateTime dateTime;
    private String message;
    private String details;
}
