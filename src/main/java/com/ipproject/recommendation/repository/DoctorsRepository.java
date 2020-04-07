package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.UUID;

@Repository
public interface DoctorsRepository extends MongoRepository<Doctor, UUID> {
    Doctor findDoctorByFirstNameAndLastName(String firstName, String lastName);

    Doctor findDoctorById(int id);
}
