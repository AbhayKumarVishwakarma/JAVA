package com.masai.modul;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private double examFee = 1000;

    public void displayDetails(){
        //print the student id, name and address of the student
        System.out.println("Id - " + getId());
        System.out.println("Name - " +  getName());
        System.out.println("Address - " + getAddress());
    }

    public abstract double payFee();

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getExamFee() {
        return examFee;
    }

//    public void setExamFee(double examFee) {
//        this.examFee = examFee;
//    }
}
