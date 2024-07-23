package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class ResponseContactsDTO {
    private Integer id;
    private String description;
    private String fulladdress;
    private String phonenumber;
    private String email;
    private int managerId;

    public ResponseContactsDTO(Integer id, String description, String full_address, String phone_number, String email, int managerId) {
        this.id = id;
        this.description = description;
        this.fulladdress = full_address;
        this.phonenumber = phone_number;
        this.email = email;
        this.managerId = managerId;
    }

    public ResponseContactsDTO() {

    }
}
