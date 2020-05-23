package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.SymptomsInfoService;
import com.ipproject.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SymptomsInfoController {

    @Autowired
    private SymptomsInfoService service;

    @RequestMapping(path = "/symptomsInfo", method = RequestMethod.GET)
    public ResponseEntity<List<SymptomsInfo>> getSymptomsInfo() {
        List<SymptomsInfo> symptomsInfo = service.getAllSymptomsInfo();
        return new ResponseEntity<List<SymptomsInfo>>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/symptomsInfo/{id}", method = RequestMethod.GET)
    public ResponseEntity<SymptomsInfo> getSymptomsInfoById(@PathVariable String id) {
        SymptomsInfo symptomsInfo = service.getSymptomById(id);
        return new ResponseEntity<>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

}
