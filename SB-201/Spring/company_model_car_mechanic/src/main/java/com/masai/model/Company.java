package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Company { // (id: int, name: String, estd_year: int)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;
    private String companyName;
    private Integer estd_year;
}
