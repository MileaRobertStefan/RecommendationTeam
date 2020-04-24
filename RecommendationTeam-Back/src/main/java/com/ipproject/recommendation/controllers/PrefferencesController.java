package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.Prefference;

import com.ipproject.recommendation.service.PrefferencesService;
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
public class PrefferencesController {

    @Autowired
    private PrefferencesService service;

    @RequestMapping(path = "/prefferences", method = RequestMethod.GET)
    public ResponseEntity<List<Prefference>> getPrefferences() {
        List<Prefference> prefferences = service.getAllPrefferences();
        return new ResponseEntity<List<Prefference>>(prefferences, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/prefferences", method = RequestMethod.POST)
    public ResponseEntity<Prefference> createOrUpdatePrefference(@RequestBody Prefference prefference) {
        Prefference newPrefference = service.createOrUpdate(prefference, prefference.getAmountOfMoney(), prefference.getHospitalType(), prefference.getDoctorGender());

        return new ResponseEntity<Prefference>(newPrefference, new HttpHeaders(), HttpStatus.CREATED);
    }
}
