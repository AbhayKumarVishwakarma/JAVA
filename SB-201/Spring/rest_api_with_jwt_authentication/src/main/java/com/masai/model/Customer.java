package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;

//	@NotBlank(message = "Name should not blank!")
//	@NotNull(message = "Name should not null!")
//	@NotEmpty(message = "Name should not empty!")
	private String name;
	
	@Column(unique = true)
//	@Email(message = "Email should be in email format!")
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include alphanumerics and special characters")
	private String password;

	private String address;
	
	private String role;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Vehicle> vehicleList = new ArrayList<>();

	public Customer(String name, String email, String password, String address, String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role = role;
	}
}
