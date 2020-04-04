package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkplacesRepository extends JpaRepository<Workplace, UUID> {
    Workplace findWorkplaceById(UUID id);
}
