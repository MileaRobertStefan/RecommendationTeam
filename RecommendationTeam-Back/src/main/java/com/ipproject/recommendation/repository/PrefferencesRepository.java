package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Prefference;
import com.ipproject.recommendation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrefferencesRepository extends MongoRepository<Prefference, String> {
    Prefference findPrefferenceById(String id);
}
