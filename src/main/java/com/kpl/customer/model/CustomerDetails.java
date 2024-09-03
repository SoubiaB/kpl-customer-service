package com.kpl.customer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CustomerDetails")
public class CustomerDetails {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String pinCode;
    private String Address;
    private String city;
    private String state;
}
