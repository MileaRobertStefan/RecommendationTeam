package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.Contact;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.models.Workplace;
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

    public User getOneUser(String firstName, String lastName) {
        return repository.findUserByFirstNameAndLastName(firstName, lastName);
    }

    public User getUserById(UUID id) {
        return repository.findUserById(id);
    }

    public User createOrUpdate(User user, Integer age, String firstName, String lastName, Integer medicalHistoryId, Contact contact, Address address, List<Integer>family) {
        user.setId(UUID.randomUUID());
        user.setAddress(address);
        user.setAge(age);
        user.setFamily(family);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMedicalHistoryId(medicalHistoryId);
        user.setContact(contact);

        user = repository.save(user);
        return user;
    }

}
