package com.abd.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyErrorDetails {
    public LocalDateTime time;
    public String message;
    public String details;
}
