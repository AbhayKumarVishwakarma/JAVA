package com.masai.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Modal {  // (id: int, model_name: String, launching_year: int)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer modalId;
    private String modelName;
    private Integer launchingYear;
}
