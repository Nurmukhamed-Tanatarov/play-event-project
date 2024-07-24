package com.micro.pe.macservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GimagesDTO {

    private Integer game_id;
    private String image_url;
    private String image_title;
    private LocalDateTime upload_time;

}
