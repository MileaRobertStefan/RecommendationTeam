package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        if (users.size() > 0) {
            return users;
        } else {
            return new ArrayList<>();
        }
    }

    public User createOrUpdate(User user) {
        user.setId(UUID.randomUUID());
        user.setAddress(null);
        user.setAge(18);
        user.setFamily(null);
        user.setFirstName("Popescu");
        user.setLastName("Ionescu");
        user.setMedicalHistoryId(1);


        user = repository.save(user);
        return user;
    }

}
