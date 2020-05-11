package com.ipproject.recommendation.repository;


import com.ipproject.recommendation.models.RaspunsPentruIoana;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends MongoRepository<RaspunsPentruIoana, String> {
    List<RaspunsPentruIoana> findAll();

    RaspunsPentruIoana findMileaTestById(String id);
}
