package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vId;

//    @NotBlank(message = "Vehicle name should not blank!")
//    @NotNull(message = "Vehicle name should not null!")
//    @NotEmpty(message = "Vehicle name should not empty!")
    private String name;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

    public Vehicle(String name) {
        this.name = name;
    }
}
