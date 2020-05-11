package com.ipproject.recommendation.service;


import com.ipproject.recommendation.models.RaspunsPentruIoana;
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

    public List<RaspunsPentruIoana> getAllMileaTest() {
        List<RaspunsPentruIoana> prefferences = repository.findAll();
        if (prefferences.size() > 0) {
            return prefferences;
        } else {
            return new ArrayList<>();
        }
    }

    public RaspunsPentruIoana getMileaTestById(String id) {
        return repository.findMileaTestById(id);
    }

    public RaspunsPentruIoana createOrUpdate(RaspunsPentruIoana prefference , List<String> doctorsID) {
        prefference.setId(UUID.randomUUID().toString());
        prefference.setDoctorsID(doctorsID);

        prefference = repository.save(prefference);
        return prefference;
    }
}
