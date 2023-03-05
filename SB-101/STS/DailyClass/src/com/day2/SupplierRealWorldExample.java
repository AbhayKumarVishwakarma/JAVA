package com.day2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

class PersonNoSupplier{
	final String name;
	private final LocalDate dateOfBirth;
	private final LocalDate currentDate;
	
	PersonNoSupplier(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.currentDate = LocalDate.now();	//say it is 19-01-2023
	}
	
	long getAge() {
		return ChronoUnit.DAYS.between(dateOfBirth, currentDate);
	}
}

class PersonWithSupplier{
	final String name;
	private final LocalDate dateOfBirth;
	private Supplier<LocalDate> currentDate;
	
	PersonWithSupplier(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.currentDate = () -> LocalDate.now();	//say it is 19-01-2023
	}
	
	long getAge() {
		return ChronoUnit.DAYS.between(dateOfBirth, currentDate.get());
	}
}

public class SupplierRealWorldExample {

	public static void main(String[] args) {
		LocalDate dob = LocalDate.parse("2001-10-15");
		PersonNoSupplier p1 = new PersonNoSupplier("Ankit", dob);
		System.out.println("The age of person is " + p1.getAge() + " days");
		
		PersonWithSupplier p2 = new PersonWithSupplier("Ankit", dob);
		System.out.println("The age of person is " + p2.getAge() + " days");
	}
}








