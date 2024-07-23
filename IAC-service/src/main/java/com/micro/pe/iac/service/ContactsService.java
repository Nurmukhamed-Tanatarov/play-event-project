package com.micro.pe.iac.service;

import com.micro.pe.iac.dto.ContactsDTO;
import com.micro.pe.iac.dto.ResponseContactsDTO;
import com.micro.pe.iac.entity.Contacts;
import com.micro.pe.iac.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    public ResponseContactsDTO createContact(ContactsDTO contactsDTO) {
        Contacts contact = new Contacts();
        contact.setDescription(contactsDTO.getDescription());
        contact.setFullAddress(contactsDTO.getFulladdress());
        contact.setPhoneNumber(contactsDTO.getPhonenumber());
        contact.setEmail(contactsDTO.getEmail());
        contact.setManagerId(contactsDTO.getManagerId());
        Contacts savedContact = contactsRepository.save(contact);

        ResponseContactsDTO responseContactsDTO = new ResponseContactsDTO();
        responseContactsDTO.setId(savedContact.getId());
        responseContactsDTO.setDescription(savedContact.getDescription());
        responseContactsDTO.setFulladdress(savedContact.getFullAddress());
        responseContactsDTO.setPhonenumber(savedContact.getPhoneNumber());
        responseContactsDTO.setEmail(savedContact.getEmail());
        responseContactsDTO.setManagerId(savedContact.getManagerId());
        return responseContactsDTO;
    }

    public List<ResponseContactsDTO> getAllContacts() {
        List<Contacts> contacts = contactsRepository.findAll();
        return contacts.stream()
                .map(contact -> new ResponseContactsDTO(
                        contact.getId(),
                        contact.getDescription(),
                        contact.getFullAddress(),
                        contact.getPhoneNumber(),
                        contact.getEmail(),
                        contact.getManagerId() != null ? contact.getManagerId() : 0 // Обработка null значения
                ))
                .collect(Collectors.toList());
    }

    public ResponseContactsDTO getContactById(int id) {
        Contacts contact = contactsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact with this id not found!"));
        ResponseContactsDTO responseContactsDTO = new ResponseContactsDTO();
        responseContactsDTO.setId(contact.getId());
        responseContactsDTO.setDescription(contact.getDescription());
        responseContactsDTO.setFulladdress(contact.getFullAddress());
        responseContactsDTO.setPhonenumber(contact.getPhoneNumber());
        responseContactsDTO.setEmail(contact.getEmail());
        responseContactsDTO.setManagerId(contact.getManagerId());
        return responseContactsDTO;
    }

    public ResponseContactsDTO updateContact(int id, ContactsDTO contactsDTO) {
        Contacts existingContact = contactsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact with this id not found!"));
        existingContact.setDescription(contactsDTO.getDescription());
        existingContact.setFullAddress(contactsDTO.getFulladdress());
        existingContact.setPhoneNumber(contactsDTO.getPhonenumber());
        existingContact.setEmail(contactsDTO.getEmail());
        existingContact.setManagerId(contactsDTO.getManagerId());
        Contacts updatedContact = contactsRepository.save(existingContact);

        ResponseContactsDTO responseContactsDTO = new ResponseContactsDTO();
        responseContactsDTO.setId(updatedContact.getId());
        responseContactsDTO.setDescription(updatedContact.getDescription());
        responseContactsDTO.setFulladdress(updatedContact.getFullAddress());
        responseContactsDTO.setPhonenumber(updatedContact.getPhoneNumber());
        responseContactsDTO.setEmail(updatedContact.getEmail());
        responseContactsDTO.setManagerId(updatedContact.getManagerId());
        return responseContactsDTO;
    }

    public void deleteContact(int id) {
        contactsRepository.deleteById(id);
    }
}
