package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class ResponseRentRulesDTO {
    private int id;
    private String description;

    public ResponseRentRulesDTO(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
