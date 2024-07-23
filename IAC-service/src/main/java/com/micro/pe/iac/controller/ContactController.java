package com.micro.pe.iac.controller;

import com.micro.pe.iac.dto.ContactsDTO;
import com.micro.pe.iac.dto.ResponseContactsDTO;
import com.micro.pe.iac.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/s2/contacts")
public class ContactController {

    @Autowired
    private ContactsService contactsService;

    @PostMapping("/addContact")
    public ResponseEntity<ResponseContactsDTO> addContact(@RequestBody ContactsDTO contactsDTO) {
        ResponseContactsDTO addedContacts = contactsService.createContact(contactsDTO);
        return ResponseEntity.ok(addedContacts);
    }

    @GetMapping("/getAllContacts")
    public ResponseEntity<List<ResponseContactsDTO>> getContacts() {
        List<ResponseContactsDTO> contacts = contactsService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/getContactByID/{id}")
    public ResponseEntity<ResponseContactsDTO> getContactById(@PathVariable("id") int id) {
        ResponseContactsDTO contacts = contactsService.getContactById(id);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping("/updateContact/{id}")
    public ResponseEntity<ResponseContactsDTO> updateContact(@PathVariable("id") int id, @RequestBody ContactsDTO contactsDTO) {
        ResponseContactsDTO updatedContact = contactsService.updateContact(id, contactsDTO);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") int id){
        contactsService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
