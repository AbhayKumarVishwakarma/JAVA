package com.masaiOrder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer UserId;

//    @Pattern(regexp = "[A-Za-z]",message = "Name should not have any number of special character ")
    private String name;

//    @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be 10 digit")
    private String mobileNumber;

    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @Email(message = "Value should be in email format")
    @Column(unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{6,12}", message = "Password must be 6-12 characters in length and can include alphanumerics and special characters")
    private String password;

    private String role;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<>();

    public Customer(String name, String mobileNumber, String address, Gender gender, String email, String password, String role) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
