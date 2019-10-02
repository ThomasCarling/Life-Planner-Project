package oldmain.events;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import oldmain.addresses.PostcodeChecker;

public class Event implements Serializable {

    private String name;
    private String details;
    private String postcode;

    private int length;

    private LocalDateTime fixedTime;
    private LocalDateTime assignedTime;

    public Event(String name, String postcode, int timeInMinutesToComplete) {
	this.name = name;
	this.postcode = postcode;
	this.length = timeInMinutesToComplete;
	

    }

    public Event(String name, int lengthInMinutes) {
	this(name, "N/A", lengthInMinutes);
    }

    public Event(String name) {
	this(name, 0);
    }


    public void changeName(String newName) {
	this.name = newName;
    }

    public String getName() {
	return name;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public String getDetails() {
	return details;
    }

    public void setPostcode(String postcode) {
	if (PostcodeChecker.check(postcode)) {
	    this.postcode = postcode;
	} else {
	    throw new IllegalArgumentException("Invalid postcode");
	}
    }

    public String getPostcode() {
	return postcode;
    }


    public void setLength(int minutes) {
	length = minutes;
    }

    public int getLength() {
	return length;
    }

    public void setFixedTime(LocalDateTime timeOfEvent) {
	this.fixedTime = timeOfEvent;
    }

    public LocalDateTime getFixedTime() {
	return fixedTime;
    }
    
    public void setAssignedTime(LocalDateTime timeAssigned) {
	this.assignedTime = timeAssigned;
    }
    
    public LocalDateTime getAssignedTime() {
	return assignedTime;
    }


    public boolean equals(Object other) {
	Event check = (Event) other;
	if (this.name.equals(check.name) && this.length == check.length && this.postcode.equals(check.postcode)) {
	    return true;
	} else {
	    return false;
	}
    }

}
