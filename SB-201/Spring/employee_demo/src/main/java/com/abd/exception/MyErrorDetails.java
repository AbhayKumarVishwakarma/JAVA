package com.abd.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class MyErrorDetails {
    private LocalDateTime dateTime;
    private String message;
    private String details;
}
