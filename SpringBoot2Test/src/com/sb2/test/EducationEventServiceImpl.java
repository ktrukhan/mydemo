package com.sb2.test;

import com.sb2.test.EducationEventService;
import com.sb2.test.EducationEvent;
import com.sb2.test.EducationEventRepository;
import com.sb2.test.ChangeHistoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationEventServiceImpl implements EducationEventService {

    @Autowired
    private EducationEventRepository eventsRepository;
    @Autowired
    private ChangeHistoryLibrary historyLib;

    public EducationEvent read(String title) {
        EducationEvent dbMember =
        eventsRepository.findByTitle(title);

        return dbMember;
    }
    
    public void add(EducationEvent educationEvent) {
        EducationEvent dbMember =
        eventsRepository.findByTitle(educationEvent.getTitle());

        if (dbMember != null) {
        //    throw new EventManagementException(ErrorMessages.MEMBER_ALREDY_EXISTS);
        }
        
        EducationEvent newEvent = eventsRepository.insert(educationEvent);

        if(null != newEvent) {
        	historyLib.createHistoryEducation(null, newEvent);
        }
    }
    
    public boolean delete(String id) {
    	EducationEvent deletedEvent = eventsRepository.findByIdField(id);
        eventsRepository.deleteById(id);
        historyLib.addHistoryDelete(deletedEvent);
        return true;
    }
    
    public boolean update(String id, EducationEvent updatedEvent) {
        EducationEvent dbMember = eventsRepository.findByIdField(id);
        EducationEvent oldEvent = createCopy(dbMember);
        if (dbMember != null) {
        	updatedEvent.setId(id);
        	EducationEvent updatedObj = eventsRepository.save(updatedEvent);
        	historyLib.createHistoryEducation(oldEvent, updatedEvent);
        	return true;
        }
		return false;
    }
    
    public EducationEvent createCopy(EducationEvent example) {
    	EducationEvent copyObj = new EducationEvent();
    	//here copy all event fields from example...
    	return copyObj;
    }

}
