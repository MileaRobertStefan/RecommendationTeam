package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.service.IllnessesService;
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
public class IllnessesController {
@Autowired
    private IllnessesService service;

    @RequestMapping(path = "/illnesses", method = RequestMethod.GET)
    public ResponseEntity<List<Illness>> getIllnesses() {
        List<Illness> illnesses = service.getAllIllnesses();
        return new ResponseEntity<List<Illness>>(illnesses, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/illnesses", method = RequestMethod.POST)
    public ResponseEntity<Illness> createOrUpdateIllness(@RequestBody Illness illness) {
        Illness newIllness = service.createOrUpdate(illness, illness.getName(), illness.getDescription(), illness.getSymptoms(), illness.getComplications(), illness.getMedication());

        return new ResponseEntity<Illness>(newIllness, new HttpHeaders(), HttpStatus.CREATED);
    }

}
