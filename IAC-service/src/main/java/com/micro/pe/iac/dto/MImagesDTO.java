package com.micro.pe.iac.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MImagesDTO {

    private String image_url;
    private String title;
    private Integer manager_id;
    private LocalDateTime upload_time;

}
