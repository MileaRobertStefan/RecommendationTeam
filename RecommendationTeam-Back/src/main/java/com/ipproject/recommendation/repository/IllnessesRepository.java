package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.models.Prefference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IllnessesRepository extends MongoRepository<Illness, String> {
    Illness findIllnessById(String id);

}
