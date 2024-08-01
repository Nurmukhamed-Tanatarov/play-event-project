package com.micro.pe.adminpanel.dto;

import lombok.Data;

@Data
public class ResponseUserDTO {
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String role;

    public ResponseUserDTO(Integer id, String email, String password, String name, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
