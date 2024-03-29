package com.day8;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
	  String name;
	  LocalDate joiningDate;
	  String state;
	  transient long mobileNumber;
	  static String citizenship;
	 
	  static {
	    citizenship = "Indian";
	  }

	  public Customer(String name, LocalDate joiningDate, String state, long mobileNumber) {
	    this.name = name;
	    this.joiningDate = joiningDate;
	    this.state = state;
	    this.mobileNumber = mobileNumber;
	  }

	  @Override
	  public String toString() {
	    return "Customer [name=" + name + ", joiningDate=" + joiningDate + ", state=" + state + ", mobileNumber="
	        + mobileNumber + "]";
	  }
}
