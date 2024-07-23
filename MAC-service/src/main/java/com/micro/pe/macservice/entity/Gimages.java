package com.micro.pe.macservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "game_images")
public class Gimages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer game_id;
    private String image_url;
    private String image_title;

}
