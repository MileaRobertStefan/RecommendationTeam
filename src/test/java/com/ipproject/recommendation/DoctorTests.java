package com.ipproject.recommendation;

import com.ipproject.recommendation.service.DoctorsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DoctorTests {

    @Autowired
    DoctorsService service;

    @Test
    void returnsDoctors() {
        assertThat(service.getAllDoctors())
                .isNotEmpty();
    }

    @Test
    void returnsADoctorByName() {
        assertThat(service.getOneDoctor("Agnes", "Roman"))
                .isNotNull();
    }

    @Test
    void returnsADoctorById() throws Exception {
        assertThat(service.getDoctorById("5eb990be4ee1fd2ce08e440d"))
                .isNotNull();
    }
}
