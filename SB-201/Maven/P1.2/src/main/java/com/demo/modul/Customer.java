package com.demo.modul;
/*
customer{
	id: int Primary key [Auto Generated]
	name: varchar
	email: varchar
	address: varchar
	data_Gb: int
	price: int
	recharge_date: yyyy-mm-dd
}
 */

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String address;
    private int date_Gb;
    private int price;
    @Temporal(TemporalType.DATE)
    private Date recharge_date;

    public Customer() {
    }

    public Customer(int id, String name, String email, String address, int date_Gb, int price, Date recharge_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.date_Gb = date_Gb;
        this.price = price;
        this.recharge_date = recharge_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDate_Gb() {
        return date_Gb;
    }

    public void setDate_Gb(int date_Gb) {
        this.date_Gb = date_Gb;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRecharge_date() {
        return recharge_date;
    }

    public void setRecharge_date(Date recharge_date) {
        this.recharge_date = recharge_date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date_Gb=" + date_Gb +
                ", price=" + price +
                ", recharge_date=" + recharge_date +
                '}';
    }
}
