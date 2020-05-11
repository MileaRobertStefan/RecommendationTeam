package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Document(collection = "MileaTest")
public class ZZZTest {

    @Id
    private String id;
    @ElementCollection
    private List<String> doctorsID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDoctorsID() {
        return doctorsID;
    }

    public void setDoctorsID(List<String> doctorsID) {
        this.doctorsID = doctorsID;
    }
}
