package oldmain.datastorage;

import java.io.Serializable;
import java.util.ArrayList;

import oldmain.events.Event;

//class to save a list of different Events

public class EventStore implements Serializable {
 
    private ArrayList<Event> allEvents;
    private String filename;
    
    
    public EventStore(String filename) {
	this.allEvents = new ArrayList<Event>();
	this.filename = filename;
    }
    
    public void add(Event newEvent) {
	allEvents.add(newEvent);
    }
    
    public void remove(Event oldEvent) {
	if (allEvents.indexOf(oldEvent) != -1) {
	    allEvents.remove(oldEvent);
	} else { 
	    throw new IllegalArgumentException("event is not on list."); 
	}
    }
    
    public void save() {
	SaveLoad.save(allEvents, filename);
    }
    public void load() {
	allEvents = (ArrayList<Event>) SaveLoad.load(filename);
    }
    public int size() {
	return allEvents.size();
    }
    public void clearMemory() {
	allEvents = new ArrayList<Event>();
    }
    public Event get(int index) {
	return allEvents.get(index);
    }
}
