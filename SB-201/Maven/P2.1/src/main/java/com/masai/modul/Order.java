package com.masai.modul;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Table Order {
		orderId
		deliveryAddress
    totalAmount
    createdAt   (Current Timestamp)
}
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;
    private String deliveryAddress;
    private int totalAmount;
    private Date createdAt = Date.valueOf(LocalDate.now());
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<>();

    public Order() {
    }

    public Order(int orderId, String deliveryAddress, int totalAmount, Date createdAt, List<Item> items) {
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
