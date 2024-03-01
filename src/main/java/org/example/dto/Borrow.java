package org.example.dto;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    private Long id;
    private String contact;
    private String userName;
    private String name;
    private String nic;
    private String email;
    private String address;
    private String password;
    private String country;

}


