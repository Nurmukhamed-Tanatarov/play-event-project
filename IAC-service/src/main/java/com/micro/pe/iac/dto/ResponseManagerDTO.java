package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class ResponseManagerDTO {
    private int id;
    private String first_name;
    private String last_name;
    private String patronymic;

    public ResponseManagerDTO(int id, String first_name, String last_name, String patronymic) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
    }
}
