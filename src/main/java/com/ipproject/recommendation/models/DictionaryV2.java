package com.ipproject.recommendation.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Entity
@Document(collection = "DictionaryV2")
public class DictionaryV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ElementCollection
    List<String> varicela;
    @ElementCollection
    List<String> conjuntivita;
    @ElementCollection
    List<String> mononucleoza;
    @ElementCollection
    List<String> pneumonie;
    @ElementCollection
    List<String> raceala;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getVaricela() {
        return varicela;
    }

    public void setVaricela(List<String> varicela) {
        this.varicela = varicela;
    }

    public List<String> getConjuntivita() {
        return conjuntivita;
    }

    public void setConjuntivita(List<String> conjuntivita) {
        this.conjuntivita = conjuntivita;
    }

    public List<String> getMononucleoza() {
        return mononucleoza;
    }

    public void setMononucleoza(List<String> mononucleoza) {
        this.mononucleoza = mononucleoza;
    }

    public List<String> getPneumonie() {
        return pneumonie;
    }

    public void setPneumonie(List<String> pneumonie) {
        this.pneumonie = pneumonie;
    }

    public List<String> getRaceala() {
        return raceala;
    }

    public void setRaceala(List<String> raceala) {
        this.raceala = raceala;
    }
}
