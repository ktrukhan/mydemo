package com.sb2.test;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

/**
 * This is data model 
 * will be saved in MongoDB
 * 
 * @author ktrukhan
 *
 */
@Document(collection = "EducationEvent")
public class EducationEvent {

    @Id
    private ObjectId id;

    @Indexed
    private String title;

    private String summary;

    private String description;

    private Date startDateTime;

    private Date endDateTime;
    

    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return title;
    }

    public void setDescription(String value) {
        this.title = value;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date value) {
        this.startDateTime = value;
    }

    public Date getEndDateTime() {
        return startDateTime;
    }

    public void setEndDateTime(Date value) {
        this.startDateTime = value;
    }

}
