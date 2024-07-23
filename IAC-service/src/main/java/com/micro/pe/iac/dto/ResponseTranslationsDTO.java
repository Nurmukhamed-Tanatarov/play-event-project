package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class ResponseTranslationsDTO {
    private Integer id;
    private Integer entity_id;
    private String entity_type;
    private String language_code;
    private String translated_text;

    public ResponseTranslationsDTO(Integer id, Integer entity_id, String entity_type, String language_code, String translated_text) {
        this.id = id;
        this.entity_id = entity_id;
        this.entity_type = entity_type;
        this.language_code = language_code;
        this.translated_text = translated_text;
    }
}
