package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Car {  // (id: int, registration_number: String, price: double, mfg_year: int)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carId;

    private String registrationNumber;
    private Integer mfgYear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Modal modal;

    @JsonIgnore
    @ManyToMany(mappedBy = "carList", fetch = FetchType.EAGER)
    private List<Mechanic> mechanicList = new ArrayList<>();
}
