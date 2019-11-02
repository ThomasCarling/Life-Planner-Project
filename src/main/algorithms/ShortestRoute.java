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
    private List<List<Node>> shortestRoutes;
    private int numberOfRoutes;
    private int shortestTime;

    public ShortestRoute(List<Node> everyNode) {
	this(null, everyNode, null);
    }

    public ShortestRoute(Node startNode, List<Node> otherNodes) {
	this(startNode, otherNodes, null);
    }

    public ShortestRoute(List<Node> otherNodes, Node endNode) {
	this(null, otherNodes, endNode);
    }

    public ShortestRoute(Node startNode, List<Node> otherNodes, Node endNode) {
	int possibleTime;
	List<Node> possibleRoute;
	
	HeapsAlgorithm allPermutations = new HeapsAlgorithm(otherNodes.size());
	
	possibleRoute = getPossibleRoute(0, allPermutations, startNode, otherNodes, endNode);
	shortestRoutes.add(possibleRoute);
	shortestTime = getPossibleTime(possibleRoute);
	numberOfRoutes = 1;
	
	for (int i = 1; i < allPermutations.getNumberOfPurmutations(); i++) {
	    possibleRoute = getPossibleRoute(i, allPermutations,startNode, otherNodes, endNode);
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
    
    public List<Node> getRoute(int routeNumber) {
	return shortestRoutes.get(routeNumber);
    }
    
    public int getTime() {
	return shortestTime;
    }
    
    private int getPossibleTime(List<Node> possibleRoute) {
	int possibleTime = 0;
	for (int i = 0; i + 1 < possibleRoute.size(); i++) {
	    Node fromHere = possibleRoute.get(i);
	    Node toHere = possibleRoute.get(i + 1);
	    possibleTime += fromHere.getTimeTo(toHere);
	}
	return possibleTime;
    }
    
    private List<Node> getPossibleRoute(int permutationNumber, HeapsAlgorithm allPossibilities, Node startNode, List<Node> otherNodes, Node endNode) {
	List<Node> possibleRoute = new ArrayList<Node>();
	if (startNode != null) {
	    possibleRoute.add(startNode);
	}
	for (int i = 0; i < allPossibilities.getLengthOfList(); i++) {
	    int index = allPossibilities.get(permutationNumber, i);
	    possibleRoute.add(otherNodes.get(index));
	}
	if (endNode !=null) {
	    possibleRoute.add(endNode);
	}
	return possibleRoute;
    }
}

