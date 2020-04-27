package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
@Document(collection = "SymptompsInfo")
public class SymptomsInfo {
    @Id
    private String id;
    @ElementCollection
    private List<String> options = new ArrayList<String>();
    @ElementCollection
    private List<String> cap = new ArrayList<String>();
    @ElementCollection
    private List<String> gat = new ArrayList<String>();
    @ElementCollection
    private List<String> piept = new ArrayList<String>();
    @ElementCollection
    private List<String> stomac = new ArrayList<String>();
    @ElementCollection
    private List<String> spate = new ArrayList<String>();
    @ElementCollection
    private List<String> brate = new ArrayList<String>();
    @ElementCollection
    private List<String> picioare = new ArrayList<String>();
    @ElementCollection
    private List<String> abdomen = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getCap() {
        return cap;
    }

    public void setCap(List<String> cap) {
        this.cap = cap;
    }

    public List<String> getGat() {
        return gat;
    }

    public void setGat(List<String> gat) {
        this.gat = gat;
    }

    public List<String> getPiept() {
        return piept;
    }

    public void setPiept(List<String> piept) {
        this.piept = piept;
    }

    public List<String> getStomac() {
        return stomac;
    }

    public void setStomac(List<String> stomac) {
        this.stomac = stomac;
    }

    public List<String> getSpate() {
        return spate;
    }

    public void setSpate(List<String> spate) {
        this.spate = spate;
    }

    public List<String> getBrate() {
        return brate;
    }

    public void setBrate(List<String> brate) {
        this.brate = brate;
    }

    public List<String> getPicioare() {
        return picioare;
    }

    public void setPicioare(List<String> picioare) {
        this.picioare = picioare;
    }

    public List<String> getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(List<String> abdomen) {
        this.abdomen = abdomen;
    }
}