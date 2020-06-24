package com.sb2.test;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sb2.test.EducationEvent;
import com.sb2.test.HistoryEntry;


public interface HistoryEntryRepository extends MongoRepository < HistoryEntry, String > {

    /**
     * Gets education event details from Mongo DB by event Title
     * 
     *
     */

    @Query("{ 'idHist' : ?0}")
    public HistoryEntry findByIdHist(String id);
    
    @Query("{ 'fieldName' : ?0}")
    public HistoryEntry findByFieldName(String fieldName);


}