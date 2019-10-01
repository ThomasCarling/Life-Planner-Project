package lifeplannerproject.algorithms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lifeplannerproject.events.Event;

public class TimetableCalculator {
    public static ArrayList<Event> calculate(ArrayList<Event> events, LocalDateTime start, LocalDateTime end) {
	
	ArrayList<String> postcodes = new ArrayList<String>();
	
	ArrayList<Event> result = getFloatingOrSetEvents(events, false);
	ArrayList<Event> floatingEvents = getFloatingOrSetEvents(events, true);
	
	
	result = sortBySetTime(result);
	
	// Still working on this.....
	
	return null;
    }

    protected static ArrayList<Event> getFloatingOrSetEvents(ArrayList<Event> events, boolean floating) {

	ArrayList<Event> result = new ArrayList<Event>();
	
	for (Event myEvent: events) {
	    if (floating) {
		if (myEvent.getFixedTime() == null) {
		    result.add(myEvent);
		}
	    }
	    if (!floating) {
		if (myEvent.getFixedTime() != null) {
		    result.add(myEvent);
		}
	    }
	}
	
	return result;
    }
    
    protected static ArrayList<Event> sortBySetTime(ArrayList<Event> events) {
	
	Comparator<Event> compareByDateTime = new Comparator<Event>() {
		public int compare(Event e1, Event e2) {
		    return e1.getFixedTime().compareTo(e2.getFixedTime());
		}
	    };
	    
	Collections.sort(events, compareByDateTime);
	return events;
    }
    
    

    
}
