package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, UUID> {
    MedicalHistory findMedicalHistoryById(UUID id);
}
