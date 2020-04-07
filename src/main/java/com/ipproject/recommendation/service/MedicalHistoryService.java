package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.MedicalHistory;
import com.ipproject.recommendation.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository repository;

    public List<MedicalHistory> getAllMedicalHistories(){
        List<MedicalHistory> medicalHistories= repository.findAll();
        if (medicalHistories.size() > 0) {
            return medicalHistories;
        } else {
            return new ArrayList<>();
        }
    }

    public MedicalHistory getMedicalHistoryById(Integer id) {
        return repository.findMedicalHistoryById(id);
    }

    public MedicalHistory createOrUpdate(MedicalHistory medicalHistory, List<Integer> illnesses, List<String>observations) {
        medicalHistory.setId(1);
        medicalHistory.setIllnesses(illnesses);
        medicalHistory.setObservations(observations);
        medicalHistory = repository.save(medicalHistory);
        return medicalHistory;
    }
}
