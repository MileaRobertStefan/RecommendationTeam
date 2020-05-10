package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Document(collection = "Prefferences")
public class Prefference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String doctorGender;
    private Integer amountOfMoney;
    private String HospitalType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getHospitalType() {
        return HospitalType;
    }

    public void setHospitalType(String hospitalType) {
        HospitalType = hospitalType;
    }
}

