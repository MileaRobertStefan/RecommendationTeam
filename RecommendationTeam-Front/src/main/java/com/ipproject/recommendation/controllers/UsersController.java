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
@RequestMapping("api/v1/users")
public class UsersController {

        @Autowired
        private UserService service;

        @GetMapping
        public ResponseEntity<List<User>> getUsers(){
            List<User> users = service.getAllUsers();
            return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<User> createOrUpdateUser(@RequestBody User user){
            User user1 = service.createOrUpdate(user);

            return new ResponseEntity<User>(user1, new HttpHeaders(), HttpStatus.CREATED);
        }
    }


