package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Embeddable
@Document(collection = "Users")
public class Address {

    private String country;
    private String city;
    private String streetName;
    private int streetNo;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }


}
