package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UsersController {

    @Autowired
    private UserService service;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getAllUsers();
        return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/user/{firstName}/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable String firstName, @PathVariable String lastName) {
        User user = service.getOneUser(firstName, lastName);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = service.getUserById(id);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user) {
        User newUser = service.createOrUpdate(user, user.getAge(), user.getFirstName(), user.getLastName(), user.getMedicalHistoryId(), user.getContact(), user.getAddress(), user.getFamily());

        return new ResponseEntity<User>(newUser, new HttpHeaders(), HttpStatus.CREATED);
    }
}


