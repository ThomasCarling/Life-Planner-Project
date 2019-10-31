package algorithms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import events.Event;

/**
 * Class to calculate the most time-efficient way to distribute a list of Events.
 * 
 * @author Thomas
 *
 */
public class TimetableCalculator {
    
    private List<Event> allEvents;
    private LocalDateTime startTime;
    
    
    /**
     * Creates new instance of a TimetableCalculator.
     * 
     * @param allEvents list of every Event to be sorted.
     */
    public TimetableCalculator(List<Event> allEvents) {
	this.allEvents = allEvents;
	this.startTime = getEarliestFixedTime();
    }
    
    /**
     * Creates new instance of a TimetableCalculator.
     * 
     * @param allEvents list of every Event to be sorted.
     * @param startTime time to start first Event.
     */
    public TimetableCalculator(List<Event> allEvents, LocalDateTime startTime) {
	this.allEvents = allEvents;
	this.startTime = startTime;
    }
    
    
    public List<Event> getEfficientRoute(LocalDateTime startTime) {
	
	List<String> postcodes = new ArrayList<String>();
	
	List<Event> result = getFloatingOrSetEvents(events, false);
	List<Event> floatingEvents = getFloatingOrSetEvents(events, true);
	
	
	result = sortBySetTime(result);
	
	// Still working on this.....
	
	return null;
    }
    
    public List<Event> getEfficientRoute() {
	if (this.startTime == null) {
	    this.startTime = getEarliestFixedTime();
	}
	return getEfficientRoute(this.startTime);
    }
    
    /**
     * private method to find the time of the earliest fixed Event.
     * 
     * @return the fixed time, as a LocalDateTime.
     */
    private LocalDateTime getEarliestFixedTime() {
	LocalDateTime earliestTime = null;
	for (Event myEvent: allEvents) {
	    LocalDateTime toCheck = myEvent.getFixedTime();
	    if (toCheck != null) {
		if (earliestTime == null) {
		    earliestTime = toCheck;
		} else {
		    earliestTime = earliestTime.isAfter(toCheck) ? toCheck : earliestTime;
		}
	    }
	}
	return earliestTime;
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
