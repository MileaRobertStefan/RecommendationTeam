package com.ipproject.recommendation.repository;


import com.ipproject.recommendation.models.Dictionary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends MongoRepository<Dictionary, String> {

    Dictionary findDictionaryById(String id);

}
