package com.sb2.test;

import com.sb2.test.EducationEventService;
import com.sb2.test.EducationEvent;
import com.sb2.test.EducationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ChangeHistoryLibrary {

    @Autowired
    private HistoryEntryRepository historyRepository;

    public void createHistoryEducation(EducationEvent eventold, EducationEvent eventnew) {
    	if(null != eventold) {
    		if(!eventold.getDescription().equals(eventnew.getDescription())) {
        		HistoryEntry hist = new HistoryEntry();
        		//fill here all fields with new and old values ...
        		addHistory(hist);
        	}
    	}else{
    		HistoryEntry hist = new HistoryEntry();
    		//fill here all fields with new and old values ...
    		addHistory(hist);
    	}
    	
    }
    
    public void addHistory(HistoryEntry history) {
        historyRepository.insert(history);
    }
    
    public void addHistoryDelete(EducationEvent eventnew) {
    	HistoryEntry hist = new HistoryEntry();
		//fill here all fields with delete values ...
		addHistory(hist);
    }
    

}
