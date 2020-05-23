package com.ipproject.recommendation;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.repository.IllnessesRepository;
import com.ipproject.recommendation.repository.UserRepository;
import com.ipproject.recommendation.service.DoctorsService;
import com.ipproject.recommendation.service.IllnessesService;
import com.ipproject.recommendation.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IllnessesTests {

    @Autowired
    IllnessesService service;
    IllnessesRepository repository;

    @Test
    void returnsIllnesses() {
        assertThat(service.getAllIllnesses())
                .isNotEmpty();
    }

    @Test
    void returnsIllnessById() {
        assertThat(service.getIllnessesById("5eb7f3a6e9b5603d346dc32e"))
                .isNotNull();
    }
}
