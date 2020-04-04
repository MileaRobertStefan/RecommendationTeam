package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.models.Prefference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IllnessesRepository extends JpaRepository<Illness, UUID> {
    Illness findIllnessById(UUID id);

}
