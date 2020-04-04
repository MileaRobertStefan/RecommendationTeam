package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.Workplace;
import com.ipproject.recommendation.service.WorkplacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class WorkplacesController {
    @Autowired
    private WorkplacesService service;

    @RequestMapping(path = "/workplaces", method = RequestMethod.GET)
    public ResponseEntity<List<Workplace>> getWorkplaces() {
        List<Workplace> workplaces = service.getAllWorkplaces();
        return new ResponseEntity<List<Workplace>>(workplaces, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/workplaces/{id}", method = RequestMethod.GET)
    public ResponseEntity<Workplace> getWorkplaceById(@PathVariable UUID id) {
        Workplace workplace = service.getOneWorkplace(id);
        return new ResponseEntity<>(workplace, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/workplaces", method = RequestMethod.POST)
    public ResponseEntity<Workplace> createOrUpdateWorkplace(@RequestBody Workplace workplace) {
        Workplace newWorkplace = service.createOrUpdate(workplace, workplace.getHospitalName(), workplace.getCountry(),workplace.getCity(), workplace.getStreetName(), workplace.getStreetNumber());

        return new ResponseEntity<Workplace>(newWorkplace, new HttpHeaders(), HttpStatus.CREATED);
    }
}
