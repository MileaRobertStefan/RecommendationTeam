package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Workplace;
import com.ipproject.recommendation.repository.WorkplacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WorkplacesService {
    @Autowired
    private WorkplacesRepository repository;

    public List<Workplace> getAllWorkplaces() {
        List<Workplace> workplaces = repository.findAll();
        if (workplaces.size() > 0) {
            return workplaces;
        } else {
            return new ArrayList<>();
        }
    }

    public Workplace getOneWorkplace(UUID id) {
        return repository.findWorkplaceById(id);
    }

    public Workplace createOrUpdate(Workplace workplace, String hospitalName, String country, String city, String streetName, Integer streetNumber) {
        workplace.setCity(city);
        workplace.setCountry(country);
        workplace.setId(UUID.randomUUID());
        workplace.setStreetName(streetName);
        workplace.setStreetNumber(streetNumber);
        workplace.setHospitalName(hospitalName);

        workplace = repository.save(workplace);
        return workplace;
    }


}
