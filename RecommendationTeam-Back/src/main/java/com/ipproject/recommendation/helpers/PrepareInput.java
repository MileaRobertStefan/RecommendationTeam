package com.ipproject.recommendation.helpers;

import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.service.DoctorsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.SecureRandom;
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

    public PrepareInput(String input, DoctorsService doctorsService) {
        try {
            JSONObject jObject = new JSONObject(input);
            jInfo = new JSONObject(jObject.get(info).toString());
            jSimptoms = new JSONObject(jObject.get(simptoms).toString());
            service = doctorsService;
        } catch (Exception ignored) {
            System.out.println(ignored);
        }

        System.out.println("1 " + doctorsService);
        System.out.println("3 " + jInfo);
        System.out.println("4 " + jSimptoms);

    }

    public List<Doctor> findMatch() throws JSONException {
        return service.find(jInfo.getString(type), jInfo.getInt(priceLimit), jInfo.getString(gender));
    }

    Map<String, String> specByBodyZone = new HashMap<String, String>()
    {
        {//proof of concept
            put("cap", "Neurologie");
            put("gat", "Endocrine");
            put("piept", "Cardiologie");
            put("stomac", "Gastroenterologie");
            put("spate", "Boli infectioase");
            put("brate", "Chirurgie Generala");
            put("picioare", "Medicina Pulmonara");
            put("abdomen", "Oncologie");
        }
    };

    public List<Doctor> findByZone() throws JSONException {
        return service.findByZone(jInfo.getString(type), jInfo.getInt(priceLimit), jInfo.getString(gender), specByBodyZone.get(jSimptoms.getString(bodyPart)));


    }
}
