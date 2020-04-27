package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "symptomsInfo")
public class Symptom {

    private String bodyZone;
    @ElementCollection
    private List<String> symptomsArray = new ArrayList<String>();

    public String getBodyZone() {
        return bodyZone;
    }

    public void setBodyZone(String bodyZone) {
        this.bodyZone = bodyZone;
    }

    public List<String> getSymptomsArray() {
        return symptomsArray;
    }

    public void setSymptomsArray(List<String> symptomsArray) {
        this.symptomsArray = symptomsArray;
    }
}
