package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@Embeddable
@Document(collection = "Users")
public class Workplace {

    private String hospitalName;
    private String country;
    private String city;
    private String streetName;
    private Integer streetNo;


    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Integer streetNo) {
        this.streetNo = streetNo;
    }
}
