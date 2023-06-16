package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Bike {
    @Id
    private String id;
    private String brand;
    private String model;
    private Integer price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public Bike() {
    }

    public Bike(String id, String brand, String model, Integer price, Date registrationDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.registrationDate = registrationDate;
    }

    public Bike(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
