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

public class TimetableCalculator {
    public static ArrayList<Event> calculate(ArrayList<Event> events, LocalDateTime start, LocalDateTime end) {
	
	List<String> postcodes = new ArrayList<String>();
	
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

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Iterator<Event> iterator() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean add(Event e) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean addAll(Collection<? extends Event> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Event> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void clear() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public Event get(int index) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Event set(int index, Event element) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void add(int index, Event element) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public Event remove(int index) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int indexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public ListIterator<Event> listIterator() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ListIterator<Event> listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Event> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
    }
    
    

    
}
