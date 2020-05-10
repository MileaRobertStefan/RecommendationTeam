package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.MedicalHistory;
import com.ipproject.recommendation.models.Prefference;
import com.ipproject.recommendation.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService service;

    @RequestMapping(path = "/medicalHistories", method = RequestMethod.GET)
    public ResponseEntity<List<MedicalHistory>> getMedicalHistories() {
        List<MedicalHistory> medicalHistories = service.getAllMedicalHistories();
        return new ResponseEntity<List<MedicalHistory>>(medicalHistories, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/medicalHistories", method = RequestMethod.POST)
    public ResponseEntity<MedicalHistory> createOrUpdateMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        MedicalHistory newMedicalHistory= service.createOrUpdate(medicalHistory, medicalHistory.getIllnesses(), medicalHistory.getObservations());

        return new ResponseEntity<MedicalHistory>(newMedicalHistory, new HttpHeaders(), HttpStatus.CREATED);
    }

}
