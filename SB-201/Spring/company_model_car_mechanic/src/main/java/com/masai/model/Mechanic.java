package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Mechanic {  // (id: int, empId: String, name: String, )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mechanicId;
    private String empId;
    private String mechanicName;
}
