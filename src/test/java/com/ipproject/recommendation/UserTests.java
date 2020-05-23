package com.ipproject.recommendation;

import com.ipproject.recommendation.repository.UserRepository;
import com.ipproject.recommendation.service.DoctorsService;
import com.ipproject.recommendation.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTests {

    @Autowired
    UserService service;
    UserRepository repository;

    @Test
    void returnsUsers() {
        assertThat(service.getAllUsers())
               .isNotEmpty();
    }

    @Test
    void returnsAUserByName() {
        assertThat(service.getOneUser("Jack", "Foster"))
                .isNotNull();
    }

    @Test
    void returnsAUserById() throws Exception {
        assertThat(service.getUserById("5e8e28c05e6372376cfeec89"))
                .isNotNull();
    }
}
