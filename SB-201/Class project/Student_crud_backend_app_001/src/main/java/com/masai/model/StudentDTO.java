package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	private String name;
	private Integer marks;
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	
}
