package com.masai.modul;

import javax.persistence.Entity;

@Entity
public class Hosteller extends Student{
    private double hostelFee;
    @Override
    public double payFee() {
        return getHostelFee() + getExamFee();
    }
    public double getHostelFee() {
        return hostelFee;
    }
    public void setHostelFee(double hostelFee) {
        this.hostelFee = hostelFee;
    }
}
