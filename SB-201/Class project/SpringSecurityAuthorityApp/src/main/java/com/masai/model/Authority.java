package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Authority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authId;
	private String name;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
}