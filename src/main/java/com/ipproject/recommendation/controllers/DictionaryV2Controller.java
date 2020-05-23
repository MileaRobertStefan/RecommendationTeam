package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.service.DictionarService;
import com.ipproject.recommendation.service.DictionaryV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class DictionaryV2Controller {
    @Autowired
    private DictionaryV2Service service;
}
