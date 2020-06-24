package com.sb2.test;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sb2.test.EducationEvent;
import com.sb2.test.HistoryEntry;


public interface EducationEventRepository extends MongoRepository < EducationEvent, String > {

    /**
     * Gets education event details from Mongo DB by event Title
     * 
     *
     */
    @Query("{ 'title' : {$regex: ?0, $options: 'i' }}")
    public EducationEvent findByTitle(String title);
    
    @Query("{ 'id' : ?0}")
    public EducationEvent findByIdField(String id);
    
    @Query(value="{'id' : $0}", delete = true)
    public void deleteById (String id);
    
    @Query("{ 'idHist' : ?0}")
    public HistoryEntry findByIdHist(String id);
    
    @Query("{ 'fieldName' : ?0}")
    public HistoryEntry findByFieldName(String fieldNAme);


}