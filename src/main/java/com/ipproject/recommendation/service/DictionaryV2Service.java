package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Dictionary;
import com.ipproject.recommendation.models.DictionaryV2;
import com.ipproject.recommendation.repository.DictionaryRepository;
import com.ipproject.recommendation.repository.DictionaryV2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryV2Service {

    @Autowired
    private DictionaryV2Repository repository;

    public DictionaryV2 getDictionaryV2() {
        List<DictionaryV2> raspuns = repository.findAll();
        if (raspuns.size() > 0) {
            return raspuns.get(0);
        } else {
            return new DictionaryV2();
        }
    }
}
