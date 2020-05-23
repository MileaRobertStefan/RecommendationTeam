package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.RecommendationList;
import com.ipproject.recommendation.repository.RecommendationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecommendationService {
    @Autowired
    RecommendationRepository repository;

    public List<RecommendationList> getAllRecommendations() {
        List<RecommendationList> prefferences = repository.findAll();
        if (prefferences.size() > 0) {
            return prefferences;
        } else {
            return new ArrayList<>();
        }
    }

    public RecommendationList getRecommendationListById(String id) {
        return repository.findRecommendationListById(id);
    }

    public RecommendationList createOrUpdate(RecommendationList prefference, List<String> doctorsID) {
        prefference.setId(UUID.randomUUID().toString());
        prefference.setDoctorsID(doctorsID);

        prefference = repository.save(prefference);
        return prefference;
    }
}
