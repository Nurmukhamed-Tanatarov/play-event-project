package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class ContactsDTO {

    private String description;
    private String full_address;
    private String phone_number;
    private String email;
    private int manager_id;

}
