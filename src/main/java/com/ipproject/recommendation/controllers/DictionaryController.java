package com.ipproject.recommendation.controllers;

import com.ipproject.recommendation.service.DictionarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class DictionaryController {

    @Autowired
    private DictionarService service;
}
