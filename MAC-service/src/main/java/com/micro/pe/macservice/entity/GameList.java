package com.micro.pe.macservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class GameList{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "categories_id")
    private Integer categoryId;
}
