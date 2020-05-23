package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.SymptomsInfo;
import com.ipproject.recommendation.repository.SymptomsInfoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomsInfoService {

    @Autowired
    private SymptomsInfoRepository repository;

    public List<SymptomsInfo> getAllSymptomsInfo() {
        List<SymptomsInfo> symptomsInfos = repository.findAll();
        if (symptomsInfos.size() > 0) {
            return symptomsInfos;
        } else {
            return new ArrayList<>();
        }
    }

    public SymptomsInfo getSymptomById(String id) {
        if(ObjectId.isValid(id)) {
            return repository.findSymptomsInfoById(id);
        }
        else return null;
    }
}