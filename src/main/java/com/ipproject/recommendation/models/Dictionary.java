package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Entity
@Document(collection = "Dictionary")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ElementCollection
    List<String> cap;
    @ElementCollection
    List<String> ochi;
    @ElementCollection
    List<String> nas;
    @ElementCollection
    List<String> dantura;
    @ElementCollection
    List<String> urechi;
    @ElementCollection
    List<String> gat;

    @ElementCollection
    List<String> piept;
    @ElementCollection
    List<String> inima;
    @ElementCollection
    List<String> stomac;
    @ElementCollection
    List<String> ficat;
    @ElementCollection
    List<String> spate;
    @ElementCollection
    List<String> brate;
    @ElementCollection
    List<String> picioare;
    @ElementCollection
    List<String> abdomen;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCap() {
        return cap;
    }

    public void setCap(List<String> cap) {
        this.cap = cap;
    }

    public List<String> getOchi() {
        return ochi;
    }

    public void setOchi(List<String> ochi) {
        this.ochi = ochi;
    }

    public List<String> getNas() {
        return nas;
    }

    public void setNas(List<String> nas) {
        this.nas = nas;
    }

    public List<String> getDantura() {
        return dantura;
    }

    public void setDantura(List<String> dantura) {
        this.dantura = dantura;
    }

    public List<String> getUrechi() {
        return urechi;
    }

    public void setUrechi(List<String> urechi) {
        this.urechi = urechi;
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

    public List<String> getInima() {
        return inima;
    }

    public void setInima(List<String> inima) {
        this.inima = inima;
    }

    public List<String> getStomac() {
        return stomac;
    }

    public void setStomac(List<String> stomac) {
        this.stomac = stomac;
    }

    public List<String> getFicat() {
        return ficat;
    }

    public void setFicat(List<String> ficat) {
        this.ficat = ficat;
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
