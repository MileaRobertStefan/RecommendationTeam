package com.ipproject.recommendation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.service.SymptomsInfoService;
import com.ipproject.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RecommendationController {

    @Autowired
    private SymptomsInfoService service;

    @RequestMapping(path = "/recommendation", method = RequestMethod.GET)
    public ResponseEntity<List<SymptomsInfo>> getRecommendation() {

        List<SymptomsInfo> symptomsInfo = service.getAllSymptomsInfo();
        return new ResponseEntity<List<SymptomsInfo>>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/recommendation", method = RequestMethod.POST)
    public ResponseEntity<List<SymptomsInfo>> postRecommendation(@RequestBody String json) {
      //  System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        try {

            Map<String, String> map = mapper.readValue(json, Map.class);
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<SymptomsInfo> symptomsInfo = service.getAllSymptomsInfo();
        return new ResponseEntity<List<SymptomsInfo>>(symptomsInfo, new HttpHeaders(), HttpStatus.OK);
    }

}
