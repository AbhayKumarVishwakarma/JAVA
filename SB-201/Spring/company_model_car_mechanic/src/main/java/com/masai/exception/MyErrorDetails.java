package com.masai.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MyErrorDetails {
    private LocalDateTime ldt;
    private String msg;
    private String details;
}
