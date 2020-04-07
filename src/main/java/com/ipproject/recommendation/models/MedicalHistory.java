package com.ipproject.recommendation.models;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Document(collection = "medicalHistory")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    private List<String> observations;

    @ElementCollection
    private List<Integer> illnesses;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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
