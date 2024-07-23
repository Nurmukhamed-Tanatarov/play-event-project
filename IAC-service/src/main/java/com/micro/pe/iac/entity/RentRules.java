package com.micro.pe.iac.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rent_rules")
public class RentRules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
}
