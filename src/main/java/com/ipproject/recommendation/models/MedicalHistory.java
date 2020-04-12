package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

import java.util.List;


@Entity
@Document(collection = "medicalHistory")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ElementCollection
    private List<String> observations;

    @ElementCollection
    private List<Integer> illnesses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getObservations() {
        return observations;
    }

    public void setObservations(List<String> observations) {
        this.observations = observations;
    }

    public List<Integer> getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(List<Integer> illnesses) {
        this.illnesses = illnesses;
    }
}
