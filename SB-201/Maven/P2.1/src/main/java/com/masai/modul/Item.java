package com.masai.modul;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

/*
Table Item {
		itemId
		name
		order_id(Foreign Key)
		estimatedDeliveryDate  (Date)
		createdAt   (Current Timestamp)
}
 */

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String name;
    @JoinColumn(name = "orderId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order; //(Foreign Key)
    private Date estimatedDeliveryDate; // (Date)
    private Date createdAt = Date.valueOf(LocalDate.now());

    public Item() {
    }

    public Item(int itemId, String name, Order order, Date estimatedDeliveryDate, Date createdAt) {
        this.itemId = itemId;
        this.name = name;
        this.order = order;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.createdAt = createdAt;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
