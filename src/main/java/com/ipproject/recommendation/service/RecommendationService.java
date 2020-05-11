package com.ipproject.recommendation.service;


import com.ipproject.recommendation.models.Prefference;

import com.ipproject.recommendation.models.ZZZTest;
import com.ipproject.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecommendationService {


    @Autowired
    RecommendationRepository repository;

    public List<ZZZTest> getAllMileaTest() {
        List<ZZZTest> prefferences = repository.findAll();
        if (prefferences.size() > 0) {
            return prefferences;
        } else {
            return new ArrayList<>();
        }
    }

    public ZZZTest getMileaTestById(String id) {
        return repository.findMileaTestById(id);
    }

    public ZZZTest createOrUpdate(ZZZTest prefference , List<String> doctorsID) {
        prefference.setId(UUID.randomUUID().toString());
        prefference.setDoctorsID(doctorsID);

        prefference = repository.save(prefference);
        return prefference;
    }
}
