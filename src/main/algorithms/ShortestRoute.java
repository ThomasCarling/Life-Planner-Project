package algorithms;


import java.util.ArrayList;
import java.util.List;

import dataStorage.AddressStore;
import events.Event;

/**
 * Class to find shortest route between a number of Events, starting at one, ending at another, and visiting every point.
 * 
 * @author Thomas
 *
 */
public class ShortestRoute {
    private List<List<Event>> shortestRoutes;
    private int numberOfRoutes;
    private int shortestTime;

    public ShortestRoute(List<Event> everyEvent) {
	this(null, everyEvent, null);
    }

    public ShortestRoute(Event startEvent, List<Event> otherEvents) {
	this(startEvent, otherEvents, null);
    }

    public ShortestRoute(List<Event> otherEvents, Event endEvent) {
	this(null, otherEvents, endEvent);
    }

    public ShortestRoute(Event startEvent, List<Event> otherEvents, Event endEvent) {
	int possibleTime;
	List<Event> possibleRoute;
	
	HeapsAlgorithm allPermutations = new HeapsAlgorithm(otherEvents.size());
	
	possibleRoute = getPossibleRoute(0, allPermutations, startEvent, otherEvents, endEvent);
	shortestRoutes.add(possibleRoute);
	shortestTime = getPossibleTime(possibleRoute);
	numberOfRoutes = 1;
	
	for (int i = 1; i < allPermutations.getNumberOfPurmutations(); i++) {
	    possibleRoute = getPossibleRoute(i, allPermutations,startEvent, otherEvents, endEvent);
	    possibleTime = getPossibleTime(possibleRoute);
	    
	    if (possibleTime == shortestTime) {
		numberOfRoutes++;
		shortestRoutes.add(possibleRoute);
	    } else if (possibleTime < shortestTime) {
		numberOfRoutes = 1;
		shortestRoutes.clear();
		shortestRoutes.add(possibleRoute);
	    }
	}
    }
    
    public int getNumberOfRoutes() {
	return numberOfRoutes;
    }
    
    public List<Event> getRoute(int routeNumber) {
	return shortestRoutes.get(routeNumber);
    }
    
    public int getTime() {
	return shortestTime;
    }
    
    private int getPossibleTime(List<Event> possibleRoute) {
	int possibleTime = 0;
	for (int i = 0; i + 1 < possibleRoute.size(); i++) {
	    Event fromHere = possibleRoute.get(i);
	    Event toHere = possibleRoute.get(i + 1);
	    possibleTime += fromHere.getTimeTo(toHere);
	}
	return possibleTime;
    }
    
    private List<Event> getPossibleRoute(int permutationNumber, HeapsAlgorithm allPossibilities, Event startEvent, List<Event> otherEvents, Event endEvent) {
	List<Event> possibleRoute = new ArrayList<Event>();
	if (startEvent != null) {
	    possibleRoute.add(startEvent);
	}
	for (int i = 0; i < allPossibilities.getLengthOfList(); i++) {
	    int index = allPossibilities.get(permutationNumber, i);
	    possibleRoute.add(otherEvents.get(index));
	}
	if (endEvent !=null) {
	    possibleRoute.add(endEvent);
	}
	return possibleRoute;
    }
}

