package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByFirstNameAndLastName(String firstName, String lastName);

    User findUserById(String id);
}
