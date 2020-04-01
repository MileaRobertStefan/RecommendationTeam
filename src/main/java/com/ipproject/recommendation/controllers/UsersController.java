package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UsersController {

        @Autowired
        private UserService service;

        @RequestMapping(path = "/users", method = RequestMethod.GET)
        public ResponseEntity<List<User>> getUsers(){
            List<User> users = service.getAllUsers();
            return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
        }

        @RequestMapping(path = "/users", method = RequestMethod.POST)
        public ResponseEntity<User> createOrUpdateUser(@RequestBody User user){
            User newUser = service.createOrUpdate(user, user.getAge(), user.getFirstName(), user.getLastName(), user.getMedicalHistoryId());

            return new ResponseEntity<User>(newUser, new HttpHeaders(), HttpStatus.CREATED);
        }
    }


