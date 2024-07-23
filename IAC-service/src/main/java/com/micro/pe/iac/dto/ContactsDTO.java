package com.micro.pe.iac.dto;

import lombok.Data;

@Data
public class ContactsDTO {

    private String description;
    private String fulladdress;
    private String phonenumber;
    private String email;
    private int managerId;

}
