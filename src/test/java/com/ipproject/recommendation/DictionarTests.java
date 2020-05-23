package com.ipproject.recommendation;

import com.ipproject.recommendation.service.DictionarService;
import com.ipproject.recommendation.service.DoctorsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DictionarTests {

    @Autowired
    DictionarService service;

    @Test
    void returnsDictionar() {
        assertThat(service.getDictionar())
                .isNotNull();    }
}
