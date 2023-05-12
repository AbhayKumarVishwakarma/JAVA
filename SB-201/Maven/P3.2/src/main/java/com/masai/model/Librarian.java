package com.masai.model;

import java.util.Objects;

public class Librarian {
    private int id;
    private String name;
    private int age;
    private int noOfBooksIssued;
    private String email;
    private String mobile;

    public Librarian(int id, String name, int age, int noOfBooksIssued, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.noOfBooksIssued = noOfBooksIssued;
        this.email = email;
        this.mobile = mobile;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNoOfBooksIssued() {
        return noOfBooksIssued;
    }

    public void setNoOfBooksIssued(int noOfBooksIssued) {
        this.noOfBooksIssued = noOfBooksIssued;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return id == librarian.id && age == librarian.age && noOfBooksIssued == librarian.noOfBooksIssued && Objects.equals(name, librarian.name) && Objects.equals(email, librarian.email) && Objects.equals(mobile, librarian.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, noOfBooksIssued, email, mobile);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", noOfBooksIssued=" + noOfBooksIssued +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
