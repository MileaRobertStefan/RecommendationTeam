package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Illness;
import com.ipproject.recommendation.repository.IllnessesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class IllnessesService {

    @Autowired
    private IllnessesRepository repository;


    public List<Illness> getAllIllnesses() {
        List<Illness> illnesses = repository.findAll();
        if (illnesses.size() > 0) {
            return illnesses;
        } else {
            return new ArrayList<>();
        }
    }

    public Illness getIllnessesById(int id) {
        return repository.findIllnessById(id);
    }

    public Illness createOrUpdate(Illness illness, String name, String description, List<String> symptoms, List<String> complications, List<String> medication) {
        illness.setId(1);
        illness.setName(name);
        illness.setDescription(description);
        illness.setComplications(complications);
        illness.setSymptoms(symptoms);
        illness.setMedication(medication);

        illness = repository.save(illness);
        return illness;
    }
}
