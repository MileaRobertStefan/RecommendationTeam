package com.ipproject.recommendation.helpers;

import com.ipproject.recommendation.models.Dictionar;
import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.service.DictionarService;
import com.ipproject.recommendation.service.DoctorsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareInput {
    //obiecte principale
    public static final String simptoms = "simptoms";
    public static final String info = "info";

    //simptome
    public static final String bodyPart = "bodyPart";
    public static final String simptomType = "simptomType";
    public static final String sick = "sick";
    public static final String lastControlDate = "lastControlDate";

    //info
    private static final String sameAddress = "sameAddress";
    private static final String actualAdress = "actualAdress";
    private static final String type = "medic";
    private static final String gender = "clinic";
    private static final String priceLimit = "priceLimit";

    private JSONObject jInfo;
    private JSONObject jSimptoms;

    @Autowired
    private DoctorsService service;
    @Autowired
    private DictionarService dictionarService;
    Map<String, List<String>> specByBodyZone;

    public PrepareInput(String input, DoctorsService doctorsService) {
        try {
            JSONObject jObject = new JSONObject(input);
            jInfo = new JSONObject(jObject.get(info).toString());
            jSimptoms = new JSONObject(jObject.get(simptoms).toString());
            service = doctorsService;
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        specByBodyZone = new HashMap<String, List<String>>();

    }

    public void init() {
        Dictionar dictionar = dictionarService.getDictionar();

        specByBodyZone.put("abdomen", dictionar.getAbdomen());
        specByBodyZone.put("brate", dictionar.getBrate());
        specByBodyZone.put("cap", dictionar.getCap());
        specByBodyZone.put("dantura", dictionar.getDantura());
        specByBodyZone.put("ficat", dictionar.getFicat());
        specByBodyZone.put("gat", dictionar.getGat());
        specByBodyZone.put("stomac", dictionar.getStomac());
        specByBodyZone.put("inima", dictionar.getInima());
        specByBodyZone.put("nas", dictionar.getNas());
        specByBodyZone.put("picioare", dictionar.getPicioare());
        specByBodyZone.put("piept", dictionar.getPiept());
        specByBodyZone.put("urechi", dictionar.getUrechi());

    }

    public List<Doctor> findMatch() throws JSONException {
        return service.find(jInfo.getString(type), jInfo.getInt(priceLimit), jInfo.getString(gender));
    }


    public List<Doctor> findByZone() throws JSONException {
        List<Doctor> doctors = new ArrayList<>();

        for (String nume : specByBodyZone.get(jSimptoms.getString(bodyPart))) {
            doctors.addAll(service.findByZone(jInfo.getString(type), jInfo.getInt(priceLimit), jInfo.getString(gender), nume));
        }

        return doctors;

    }
}
