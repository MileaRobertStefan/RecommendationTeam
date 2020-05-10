package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.DoctorsService;
import com.ipproject.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class DoctorsController {
    @Autowired
    private DoctorsService service;

    @RequestMapping(path = "/doctors", method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> getDoctors() {
        List<Doctor> doctors = service.getAllDoctors();
        return new ResponseEntity<List<Doctor>>(doctors, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> getDoctors() {

        return new ResponseEntity<>("Hello world", new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/doctors/{firstName}/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<Doctor> getDoctor(@PathVariable String firstName, @PathVariable String lastName) {
        Doctor doctor = service.getOneDoctor(firstName, lastName);
        return new ResponseEntity<>(doctor, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/doctors/{id}", method = RequestMethod.GET)
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        Doctor doctor = service.getDoctorById(id);
        return new ResponseEntity<>(doctor, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/doctors", method = RequestMethod.POST)
    public ResponseEntity<Doctor> createOrUpdateDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = service.createOrUpdate(doctor, doctor.getAge(), doctor.getFirstName(), doctor.getLastName(), doctor.getSpeciality(), doctor.getRating(), doctor.getContact(), doctor.getWorkplaces(),doctor.getDisponibility(), doctor.getGender(), doctor.getAmountOfMoney());

        return new ResponseEntity<Doctor>(newDoctor, new HttpHeaders(), HttpStatus.CREATED);
    }
}
