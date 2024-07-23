package com.micro.pe.iac.service;

import com.micro.pe.iac.entity.Contacts;
import com.micro.pe.iac.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    public Contacts createContact(Contacts contact) {
        return contactsRepository.save(contact);
    }

    public List<Contacts> getAllContacts() {
        return contactsRepository.findAll();
    }

    public Contacts getContactById(int id) {
        return contactsRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact with this id not found! "));
    }

    public Contacts updateContact(int id, Contacts contact) {
        Contacts existingContact = contactsRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact with this id not found! "));
        existingContact.setDescription(contact.getDescription());
        existingContact.setFullAddress(contact.getFullAddress());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        existingContact.setEmail(contact.getEmail());
        existingContact.setManagerId(contact.getManagerId());
        return contactsRepository.save(existingContact);
    }

    public void deleteContact(int id) {
        try {
            contactsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Contact with this id not found! ", e);
        }

    }

}
