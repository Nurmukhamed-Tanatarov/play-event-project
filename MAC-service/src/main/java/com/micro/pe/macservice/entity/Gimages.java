package com.micro.pe.macservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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
    private LocalDateTime upload_time;
    private String type;
    @Column(name = "data")
    private byte[] data;
}
