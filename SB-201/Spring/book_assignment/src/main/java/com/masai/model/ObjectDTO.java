package com.masai.model;

import lombok.Data;

@Data
public class ObjectDTO {
    private String name;
    private String author;
    private String publication;
    private String category;
    private Integer page;
    private Integer price;
}
