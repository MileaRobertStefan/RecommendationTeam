package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicalHistoryRepository extends MongoRepository<MedicalHistory, Integer> {
    MedicalHistory findMedicalHistoryById(Integer id);
}
