package com.micro.pe.iac.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "translations")
public class Translations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer entity_id;
    private String entity_type;
    private String language_code;
    private String translated_text;

}
