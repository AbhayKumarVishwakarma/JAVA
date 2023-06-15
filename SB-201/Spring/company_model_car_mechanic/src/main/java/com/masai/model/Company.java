package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Company { // (id: int, name: String, estd_year: int)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;

    private String companyName;
    private Integer estd_year;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Modal> modalList = new ArrayList<>();
}
