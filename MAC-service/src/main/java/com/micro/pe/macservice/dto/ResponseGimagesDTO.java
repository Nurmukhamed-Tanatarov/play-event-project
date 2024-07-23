package com.micro.pe.macservice.dto;

import lombok.Data;

@Data
public class ResponseGimagesDTO {
    private Integer game_id;
    private String image_url;
    private String image_title;

    public ResponseGimagesDTO(int id, Integer gameId, String imageTitle, String imageUrl) {
    }

    public ResponseGimagesDTO(Integer game_id, String image_url, String image_title) {
        this.game_id = game_id;
        this.image_url = image_url;
        this.image_title = image_title;
    }
}
