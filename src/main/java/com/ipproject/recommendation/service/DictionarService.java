package com.ipproject.recommendation.service;


import com.ipproject.recommendation.models.Dictionary;
import com.ipproject.recommendation.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionarService {

    @Autowired
    private DictionaryRepository repository;

    public Dictionary getDictionar() {
        List<Dictionary> raspuns = repository.findAll();
        if (raspuns.size() > 0) {
            return raspuns.get(0);
        } else {
            return new Dictionary();
        }
    }

}
