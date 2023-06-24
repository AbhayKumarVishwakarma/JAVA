package com.masaiOrder.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    private String productName;
    private Integer quantity;
    private Integer price;

    @OneToOne
    private Order order;
}
