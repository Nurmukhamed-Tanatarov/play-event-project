package com.micro.pe.iac.controller;

import com.micro.pe.iac.entity.Contacts;
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
    public ResponseEntity<Contacts> addContact(@RequestBody Contacts contacts) {
        Contacts addedcontacts = contactsService.createContact(contacts);
        return ResponseEntity.ok(addedcontacts);
    }

    @GetMapping("/getAllContacts")
    public ResponseEntity<List<Contacts>> getContacts() {
        List<Contacts> contacts = contactsService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/getContactByID/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable("id") int id) {
        Contacts contacts = contactsService.getContactById(id);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping("/updateContact/{id}")
    public ResponseEntity<Contacts> updateContact(@PathVariable("id") int id, @RequestBody Contacts contacts) {
        Contacts updatedContact = contactsService.updateContact(id, contacts);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<Contacts> deleteContact(@PathVariable("id") int id){
        contactsService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
