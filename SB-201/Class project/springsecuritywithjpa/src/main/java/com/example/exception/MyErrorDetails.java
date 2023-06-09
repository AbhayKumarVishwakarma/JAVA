package com.example.exception;

import lombok.*;

import java.time.LocalDateTime;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {
    private LocalDateTime time;
    private String message;
    private String details;
}
