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

@Document(collection = "HistoryEntry")
public class HistoryEntry {

    @Id
    private ObjectId idHist;

    @Indexed
    private String fieldName; //document name + field name

    private String updateType;

    private String oldValue;

    private String newValue;

    private Date updateDateTime;
    
    public String getIdHist()
    {
    	return idHist.toString();
    }

    public void setId(String id)
    {
    	this.idHist = new ObjectId(id);
    }
    
    public String getFieldName()
    {
    	return fieldName;
    }

    public void setFieldName(String name)
    {
    	this.fieldName = name;
    }
    
    public String getOldValue()
    {
    	return oldValue;
    }

    public void setOldValue(String value)
    {
    	this.oldValue = value;
    }
    
    public String getNewValue()
    {
    	return newValue;
    }

    public void setNewValue(String value)
    {
    	this.oldValue = value;
    }
    
    public Date getDate()
    {
    	return this.updateDateTime;
    }

    public void setDate(Date value)
    {
    	this.updateDateTime = value;
    }
    
}
