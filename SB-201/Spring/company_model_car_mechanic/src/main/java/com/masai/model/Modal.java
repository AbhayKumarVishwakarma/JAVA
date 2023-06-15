package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Modal {  // (id: int, model_name: String, launching_year: int)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer modalId;
    private String modelName;
    private Integer launchingYear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @JsonIgnore
    @OneToMany(mappedBy = "modal", fetch = FetchType.EAGER)
    private List<Car> carList = new ArrayList<>();
}
