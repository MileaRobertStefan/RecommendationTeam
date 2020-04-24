package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.Contact;
import com.ipproject.recommendation.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping
    public ResponseEntity<List<Contact>> getContact() {
        List<Contact> contacts = service.getAllContacts();
        return new ResponseEntity<List<Contact>>(contacts, new HttpHeaders(), HttpStatus.OK);
    }
}
