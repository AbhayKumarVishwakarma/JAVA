package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Mechanic {  // (id: int, empId: String, name: String, )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mechanicId;
    private String empId;
    private String mechanicName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> carList = new ArrayList<>();
}
