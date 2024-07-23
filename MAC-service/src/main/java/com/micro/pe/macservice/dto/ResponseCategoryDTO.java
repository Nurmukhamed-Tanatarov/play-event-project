package com.micro.pe.macservice.dto;

import lombok.Data;

@Data
public class ResponseCategoryDTO {
    private int id;
    private String category_title;
    private String category_type;

    public ResponseCategoryDTO(int id, String category_title, String category_type) {
        this.id = id;
        this.category_title = category_title;
        this.category_type = category_type;
    }
}
