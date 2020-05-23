package com.ipproject.recommendation.helpers;

import com.ipproject.recommendation.models.Dictionary;
import com.ipproject.recommendation.models.DictionaryV2;
import com.ipproject.recommendation.models.Doctor;
import com.ipproject.recommendation.service.DictionarService;
import com.ipproject.recommendation.service.DictionaryV2Service;
import com.ipproject.recommendation.service.DoctorsService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
     private DictionaryV2Service dictionaryV2Service;

    Map<String, List<String>> specByIllness;
    Map<String, List<String>> specByBodyZone;

    public PrepareInput(String input, DoctorsService doctorsService, DictionarService dictionary) {
        try {
            JSONObject jObject = new JSONObject(input);
            jInfo = new JSONObject(jObject.get(info).toString());
            jSimptoms = new JSONObject(jObject.get(simptoms).toString());
            service = doctorsService;
            dictionarService = dictionary;
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        specByBodyZone = new HashMap<String, List<String>>();
        init();
    }

    public PrepareInput(String input, DoctorsService doctorsService, DictionaryV2Service dictionary) {
        try {
            JSONObject jObject = new JSONObject(input);
            jInfo = new JSONObject(jObject.get(info).toString());
            jSimptoms = new JSONObject(jObject.get(simptoms).toString());
            service = doctorsService;
            dictionaryV2Service = dictionary;
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        specByIllness = new HashMap<String, List<String>>();
        init2();
    }

    public void init() {
        Dictionary dictionary = dictionarService.getDictionar();

        specByBodyZone.put("abdomen", dictionary.getAbdomen());
        specByBodyZone.put("brate", dictionary.getBrate());
        specByBodyZone.put("cap", dictionary.getCap());
        specByBodyZone.put("dantura", dictionary.getDantura());
        specByBodyZone.put("ficat", dictionary.getFicat());
        specByBodyZone.put("gat", dictionary.getGat());
        specByBodyZone.put("stomac", dictionary.getStomac());
        specByBodyZone.put("inima", dictionary.getInima());
        specByBodyZone.put("nas", dictionary.getNas());
        specByBodyZone.put("picioare", dictionary.getPicioare());
        specByBodyZone.put("piept", dictionary.getPiept());
        specByBodyZone.put("urechi", dictionary.getUrechi());

    }

    public void init2() {
        DictionaryV2 dictionary = dictionaryV2Service.getDictionaryV2();

        specByIllness.put("varicela", dictionary.getVaricela());
        specByIllness.put("conjunctivita", dictionary.getConjuntivita());
        specByIllness.put("mononucleoza", dictionary.getMononucleoza());
        specByIllness.put("pneumonie", dictionary.getPneumonie());
        specByIllness.put("raceala", dictionary.getRaceala());

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

    public List<Doctor> findByIllness() throws JSONException {
        List<Doctor> doctors = new ArrayList<>();

        for (String nume : specByIllness.get(jSimptoms.getString(bodyPart))) {

            doctors.addAll(service.findByZone(jInfo.getString(type), jInfo.getInt(priceLimit), jInfo.getString(gender), nume));
        }

        return doctors;

    }
}
