package com.modul;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderNumber;
    private String pizza;
    private int price;
    private String address;
    @Temporal(TemporalType.DATE)
    private Date time;

    public Order() {
    }

    public Order(int id, String orderNumber, String pizza, int price, String address, Date time) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.pizza = pizza;
        this.price = price;
        this.address = address;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", pizza='" + pizza + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", time=" + time +
                '}';
    }
}


