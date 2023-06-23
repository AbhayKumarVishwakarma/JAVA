package com.masaiOrder.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderID;
    private LocalDate orderDate = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
}
