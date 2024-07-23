package com.micro.pe.iac.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @JsonProperty("full_address")
    private String fullAddress;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String email;
    @JsonProperty("manager_id")
    private Integer managerId;

}
