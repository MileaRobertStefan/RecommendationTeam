package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Prefference;
import com.ipproject.recommendation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrefferencesRepository extends JpaRepository<Prefference, UUID> {
    Prefference findPrefferenceById(UUID id);
}
