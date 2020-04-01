package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Contact;
import com.ipproject.recommendation.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public List<Contact> getAllContacts() {
        List<Contact> contacts = repository.findAll();
        if (contacts.size() > 0) {
            return contacts;
        } else {
            return new ArrayList<>();
        }
    }

    public Contact createOrUpdate(Contact contact, String phoneNumber, String email) {
        contact.setId(UUID.randomUUID());
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);

        contact = repository.save(contact);
        return contact;
    }

}
