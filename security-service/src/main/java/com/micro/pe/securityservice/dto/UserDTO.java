package com.micro.pe.securityservice.dto;

import lombok.Value;

@Value
public class UserDTO {
    Integer id;
    String email;
    String name;
    String role;
}
