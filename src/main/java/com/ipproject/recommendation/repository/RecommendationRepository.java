package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.RecommendationList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends MongoRepository<RecommendationList, String> {
    List<RecommendationList> findAll();

    RecommendationList findRecommendationListById(String id);
}
