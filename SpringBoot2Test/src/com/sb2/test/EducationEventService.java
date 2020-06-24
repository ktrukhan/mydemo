package com.sb2.test;

import com.sb2.test.EducationEvent;

/**
 * This interface defines the functionality defined on education event data object
 * 
 * @author ktrukhan
 *
 */

public interface EducationEventService {
	
   public static final String documentName = "EducationEvent";
   
   public static final String[] fieldsNames = {"description", "title", "summary", "startDate", "endDate"};

   void add(EducationEvent event);

   EducationEvent read(String id);

   boolean update(String id, EducationEvent event);

   boolean delete(String id);
}
