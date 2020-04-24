package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SymptomsInfoRepository extends MongoRepository<SymptomsInfo, UUID> {
    SymptomsInfo findSymptomsInfoById(String id);
}