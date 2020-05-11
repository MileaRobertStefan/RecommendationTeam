package com.ipproject.recommendation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipproject.recommendation.helpers.PrepareInput;
import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.models.ZZZTest;
import com.ipproject.recommendation.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RecommendationController {

    @Autowired
    private SymptomsInfoService service;
    @Autowired
    private DoctorsService serviceDoctor;
    @Autowired
    private RecommendationService recommendationService;

    @RequestMapping(path = "/recommendation", method = RequestMethod.GET)
    public ResponseEntity<List<SymptomsInfo>> getRecommendation() {

        List<SymptomsInfo> symptomsInfo = service.getAllSymptomsInfo();
        return new ResponseEntity<List<SymptomsInfo>>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/recommendation", method = RequestMethod.POST)
    public ResponseEntity<String> postRecommendation(@RequestBody String input) {
        // System.out.println(json);

        try {
            PrepareInput prepareInput = new PrepareInput(input, serviceDoctor);

            List<Doctor> doctorList = (prepareInput.findMatch());
            List<String> strings = new ArrayList<>();
            doctorList.forEach(doctor -> {
                strings.add(doctor.getId());
            });


            String s ="{ \"guid\":\"" +  recommendationService.createOrUpdate(new ZZZTest(), strings).getId() + "\" }";
            return new ResponseEntity<String>(s, new HttpHeaders(), HttpStatus.OK);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(path = "/testmilea/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> getUserById(@PathVariable String id) {
        ZZZTest zzzTest = recommendationService.getMileaTestById(id);
        List<Doctor> doctorList = new ArrayList<>();
        zzzTest.getDoctorsID().forEach( s -> {
            Doctor doctor = serviceDoctor.getDoctorById(s);
            doctorList.add(doctor);
        });
        return new ResponseEntity<>(doctorList, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/testmilea", method = RequestMethod.POST)
    public ResponseEntity<List<ZZZTest>> postTest(@RequestBody String input) {
        // System.out.println(json);

        PrepareInput prepareInput = new PrepareInput(input, serviceDoctor);
        return new ResponseEntity<List<ZZZTest>>(recommendationService.getAllMileaTest(), new HttpHeaders(), HttpStatus.OK);


    }

}
