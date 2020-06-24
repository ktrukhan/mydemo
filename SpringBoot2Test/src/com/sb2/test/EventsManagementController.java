package com.sb2.test;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.sb2.test.EducationEventService;
import com.sb2.test.EducationEvent;


/**
 *  This class open REST API for user.
 * 
 * @author ktrukhan
 *
 */
@RestController
@RequestMapping("/addEvent")
public class EventsManagementController {
    @Autowired
    private EducationEventService eventService;

    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "/addEvent")
    public void add(@RequestBody EducationEvent educationEvent) {
        //ResponseTo responseTo = new ResponseDTO(ResponseDTO.Status.SUCCESS,
        //    MessageConstants.MEMBER_ADDED_SUCCESSFULLY);
        try {
            eventService.add(educationEvent);
        } catch (Exception e) {
           // responseTo.setStatus(ResponseTo.Status.FAIL);
           // responseTo.setMessage(e.getMessage());
        }
        //return responseTo;
    }
    
    @GetMapping(value = "/getEvent/{title}")
    public ResponseEntity<EducationEvent> read(@PathVariable(name = "title") String title) {
       final EducationEvent educationEvent = eventService.read(title);

       return educationEvent != null
               ? new ResponseEntity<>(educationEvent, HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping(value = "/updateEvent/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody EducationEvent educationEvent) {
       final boolean updated = eventService.update(id, educationEvent);

       return updated
               ? new ResponseEntity<>(HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/deleteEvent/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
       final boolean deleted = eventService.delete(id);

       return deleted
               ? new ResponseEntity<>(HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
