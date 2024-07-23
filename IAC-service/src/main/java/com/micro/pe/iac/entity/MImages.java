package com.micro.pe.iac.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "manager_images")
public class MImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image_url;
    private String title;
    private Integer manager_id;
    private LocalDateTime upload_time;
    private String type;
    @Column(name = "data")
    private byte[] data;
}
