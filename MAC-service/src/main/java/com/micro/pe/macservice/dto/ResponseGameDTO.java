package com.micro.pe.macservice.dto;

import lombok.Data;

@Data
public class ResponseGameDTO {
    private int id;
    private String title;
    private String price;
    private String description;
    private String info;
    private Integer gameListId;

    public ResponseGameDTO(int id, String title, String price, String description, String info, Integer gameListId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.info = info;
        this.gameListId = gameListId;
    }
}

