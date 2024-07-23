package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class TranslationsDTO {
    private Integer entity_id;
    private String entity_type;
    private String language_code;
    private String translated_text;
}
