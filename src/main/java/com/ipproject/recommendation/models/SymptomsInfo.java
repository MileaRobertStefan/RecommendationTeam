package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "symptomsInfo")
public class SymptomsInfo {
    private String id;
    @ElementCollection
    private List<Symptom> symptoms = new ArrayList<Symptom>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}
