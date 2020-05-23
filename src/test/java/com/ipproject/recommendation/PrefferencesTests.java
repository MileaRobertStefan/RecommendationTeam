package com.ipproject.recommendation;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.models.MedicalHistory;
import com.ipproject.recommendation.repository.IllnessesRepository;
import com.ipproject.recommendation.repository.MedicalHistoryRepository;
import com.ipproject.recommendation.repository.PrefferencesRepository;
import com.ipproject.recommendation.repository.UserRepository;
import com.ipproject.recommendation.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PrefferencesTests {

    @Autowired
    PrefferencesService service;
    PrefferencesRepository repository;

    @Test
    void returnsPrefferences() {
        assertThat(service.getAllPrefferences())
                .isNotEmpty();
    }

    @Test
    void returnsPrefferenceById() {
        assertThat(service.getPrefferenceById("5eb7f3d1e9b5603d346dc342"))
                .isNotNull();
    }
}
