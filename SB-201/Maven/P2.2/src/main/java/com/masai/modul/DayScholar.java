package com.masai.modul;

import javax.persistence.Entity;

@Entity
public class DayScholar extends Student{
    private double transportFee;
    @Override
    public double payFee() {
        return getTransportFee() + getExamFee();
    }
    public double getTransportFee() {
        return transportFee;
    }
    public void setTransportFee(double transportFee) {
        this.transportFee = transportFee;
    }
}
