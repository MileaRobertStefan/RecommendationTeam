package com.ipproject.recommendation;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.models.MedicalHistory;
import com.ipproject.recommendation.repository.IllnessesRepository;
import com.ipproject.recommendation.repository.MedicalHistoryRepository;
import com.ipproject.recommendation.repository.UserRepository;
import com.ipproject.recommendation.service.DoctorsService;
import com.ipproject.recommendation.service.IllnessesService;
import com.ipproject.recommendation.service.MedicalHistoryService;
import com.ipproject.recommendation.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MedicalHistoryTests {

    @Autowired
    MedicalHistoryService service;
    MedicalHistoryRepository repository;

    @Test
    void returnsMedicalHistories() {
        assertThat(service.getAllMedicalHistories())
                .isNotEmpty();
    }

    @Test
    void returnsMedicalHistoryById() {
        assertThat(service.getMedicalHistoryById("5eb7f3b7e9b5603d346dc338"))
                .isNotNull();
    }
}
