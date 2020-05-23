package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.models.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorsRepository extends MongoRepository<Doctor, String> {
    Doctor findDoctorByFirstNameAndLastName(String firstName, String lastName);

    Doctor findDoctorById(String id);

    @Query(value = " {'workplaces.type': ?0, 'gender' : ?1 , 'amountOfMoney' : {$lt : ?2} }")
    List<Doctor> find(String type, String gender, Integer amountOfMoney);

    @Query(value = " {'workplaces.type': ?0, 'gender' : ?1 , 'amountOfMoney' : {$lt : ?2} , 'speciality'  : ?3 }")
    List<Doctor> findByZone(String type, String gender, Integer amountOfMoney, String speciality);


}
