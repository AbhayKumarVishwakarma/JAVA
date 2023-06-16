package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String publication;
    private String category;
    private Integer page;
    private Integer price;
    private String authorNo;
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private Role role;
}
