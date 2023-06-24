package com.masaiOrder.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_table")
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
