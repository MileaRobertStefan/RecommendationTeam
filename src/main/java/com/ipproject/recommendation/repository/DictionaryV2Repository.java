package com.ipproject.recommendation.repository;

import com.ipproject.recommendation.models.Dictionary;
import com.ipproject.recommendation.models.DictionaryV2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryV2Repository extends MongoRepository<DictionaryV2, String> {
}
