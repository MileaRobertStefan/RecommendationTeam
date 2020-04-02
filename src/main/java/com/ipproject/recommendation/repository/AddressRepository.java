package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

    Address findAddressById(UUID id);
}
