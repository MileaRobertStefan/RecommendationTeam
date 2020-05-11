package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.helpers.PrepareInput;
import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.models.RaspunsPentruIoana;
import com.ipproject.recommendation.service.*;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private  DictionarService dictionarService;

    @RequestMapping(path = "/recommendation", method = RequestMethod.GET)
    public ResponseEntity<List<SymptomsInfo>> getRecommendation() {

        List<SymptomsInfo> symptomsInfo = service.getAllSymptomsInfo();
        return new ResponseEntity<List<SymptomsInfo>>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/recommendation", method = RequestMethod.POST)
    public ResponseEntity<String> postRecommendation(@RequestBody String input) {
        // System.out.println(json);

        try {
            PrepareInput prepareInput = new PrepareInput(input, serviceDoctor ,dictionarService);

            List<Doctor> doctorList = (prepareInput.findByZone());
            List<String> strings = new ArrayList<>();
            doctorList.forEach(doctor -> {
                strings.add(doctor.getId());
            });


            String s ="{ \"guid\":\"" +  recommendationService.createOrUpdate(new RaspunsPentruIoana(), strings).getId() + "\" }";
            return new ResponseEntity<String>(s, new HttpHeaders(), HttpStatus.OK);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(path = "/testmilea/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Doctor>> getUserById(@PathVariable String id) {
        RaspunsPentruIoana raspunsPentruIoana = recommendationService.getMileaTestById(id);
        List<Doctor> doctorList = new ArrayList<>();
        raspunsPentruIoana.getDoctorsID().forEach(s -> {
            Doctor doctor = serviceDoctor.getDoctorById(s);
            doctorList.add(doctor);
        });
        return new ResponseEntity<>(doctorList, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/testmilea", method = RequestMethod.POST)
    public ResponseEntity<List<RaspunsPentruIoana>> postTest(@RequestBody String input) {
        // System.out.println(json);

        PrepareInput prepareInput = new PrepareInput(input, serviceDoctor ,dictionarService);
        return new ResponseEntity<List<RaspunsPentruIoana>>(recommendationService.getAllMileaTest(), new HttpHeaders(), HttpStatus.OK);


    }

}
