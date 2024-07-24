package com.micro.pe.macservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "game_rent_rules")
public class GameRentRules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "game_id")
    private int gameId;

    @Column(name = "rent_rules_id")
    private int rentRulesId;

    private String description;
}
