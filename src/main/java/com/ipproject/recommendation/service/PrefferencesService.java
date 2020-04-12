package com.ipproject.recommendation.service;


import com.ipproject.recommendation.models.Prefference;
import com.ipproject.recommendation.repository.PrefferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PrefferencesService {

    @Autowired
    private PrefferencesRepository repository;

    public List<Prefference> getAllPrefferences() {
        List<Prefference> prefferences = repository.findAll();
        if (prefferences.size() > 0) {
            return prefferences;
        } else {
            return new ArrayList<>();
        }
    }

    public Prefference getPrefferenceById(String id) {
        return repository.findPrefferenceById(id);
    }

    public Prefference createOrUpdate(Prefference prefference, Integer amountOfMoney, String hospitalType, String doctorGender) {
        prefference.setId(UUID.randomUUID().toString());
        prefference.setAmountOfMoney(amountOfMoney);
        prefference.setDoctorGender(doctorGender);
        prefference.setHospitalType(hospitalType);

        prefference = repository.save(prefference);
        return prefference;
    }
}
