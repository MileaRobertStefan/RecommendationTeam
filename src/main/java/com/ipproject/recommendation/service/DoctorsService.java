package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Contact;
import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.Workplace;
import com.ipproject.recommendation.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository repository;

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = repository.findAll();
        if (doctors.size() > 0) {
            return doctors;
        } else {
            return new ArrayList<>();
        }
    }

    public Doctor getOneDoctor(String firstName, String lastName) {
        return repository.findDoctorByFirstNameAndLastName(firstName, lastName);
    }

    public Doctor getDoctorById(UUID id) {
        return repository.findDoctorById(id);
    }

    public Doctor createOrUpdate(Doctor doctor, Integer age, String firstName, String lastName, List<String>speciality, double rating, Contact contact, List<Workplace>workplaces, List<String> disponibility) {
        doctor.setId(UUID.randomUUID());
        doctor.setWorkplaces(workplaces);
        doctor.setAge(age);
        doctor.setContact(contact);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setDisponibility(disponibility);
        doctor.setRating(rating);
        doctor.setSpeciality(speciality);

        doctor = repository.save(doctor);
        return doctor;
    }


}
