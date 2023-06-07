package com.masaischool.revision_jdbc_hibernate;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "customer_name", nullable = false, unique = true, length = 50)
	private String name;
	@Enumerated(EnumType.STRING)
	private CustomerType type;
	@Column(name = "credit_limit", precision = 7, scale = 2)
	private BigDecimal creditLimit;
	private LocalDate joiningDate;

	public Customer() {
		super();
	}

	public Customer(String name, CustomerType type, BigDecimal creditLimit, LocalDate joiningDate) {
		super();
		this.name = name;
		this.type = type;
		this.creditLimit = creditLimit;
		this.joiningDate = joiningDate;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", type=" + type + ", creditLimit=" + creditLimit
				+ ", joiningDate=" + joiningDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
}