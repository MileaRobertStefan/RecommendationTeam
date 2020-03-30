package com.ipproject.recommendation.models;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Address {


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

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public UUID getId() {return id;}

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;
    private String country;
    private String streetName;
    private String city;
    private Integer streetNumber;
}
