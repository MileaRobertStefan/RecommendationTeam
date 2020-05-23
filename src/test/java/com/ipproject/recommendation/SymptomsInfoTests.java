package com.ipproject.recommendation;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.models.MedicalHistory;
import com.ipproject.recommendation.repository.*;
import com.ipproject.recommendation.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SymptomsInfoTests {

    @Autowired
    SymptomsInfoService service;
    SymptomsInfoRepository repository;

    @Test
    void returnsNoSymptomsInfo() {
        assertThat(service.getAllSymptomsInfo())
                .isNotEmpty();
    }

    @Test
    void returnsNoSymptomsInfoById() {
        assertThat(service.getSymptomById("5e94aa37019a14fb0a071460"))
                .isNotNull();
    }
}
