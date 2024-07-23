package com.micro.pe.securityservice.dto;

import com.micro.pe.securityservice.entity.Users;
import lombok.Data;

@Data
public class SignupResponse {
    private Integer statusCode;
    private String message;
    private Users users;
    private String error;

}
