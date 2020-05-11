package com.ipproject.recommendation.repository;


import com.ipproject.recommendation.models.Prefference;
import com.ipproject.recommendation.models.ZZZTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends MongoRepository<ZZZTest, String> {
    List<ZZZTest> findAll();

    ZZZTest findMileaTestById(String id);
}
