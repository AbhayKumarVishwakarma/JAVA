package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Car {  // (id: int, registration_number: String, price: double, mfg_year: int)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carId;
    private String registrationNumber;
    private Integer mfgYear;
}
