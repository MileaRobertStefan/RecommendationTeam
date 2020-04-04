package com.ipproject.recommendation.models;
import javax.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ElementCollection
    private List<String> observations;

    @ElementCollection
    private List<Integer> illnesses;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
