package com.ipproject.recommendation.service;


import com.ipproject.recommendation.models.Dictionar;
import com.ipproject.recommendation.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DictionarService {
    @Autowired
    DictionaryRepository repository;

  public   Dictionar getDictionar() {

        List<Dictionar> raspuns = repository.findAll();
        if (raspuns.size() > 0) {
            return raspuns.get(0);
        } else return new Dictionar();
    }

}
