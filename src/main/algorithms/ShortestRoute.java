package algorithms;


import java.util.ArrayList;
import java.util.List;

/**
 * Class to find shortest route/routes between a number of Node(s), starting at one, 
 * ending at another, and visiting every point once.
 * 
 * @author Thomas
 *
 */
public class ShortestRoute {
    private List<List<Node>> shortestRoutes;
    private int numberOfRoutes;
    private int shortestTime;

    /**
     * Creates a new instance of ShortestRoute.
     * 
     * @param everyNode All of the Nodes to pass through, no specified beginning or end point.
     */
    public ShortestRoute(List<Node> everyNode) {
	this(null, everyNode, null);
    }
    
    /**
     * Creates a new instance of ShortestRoute.
     * 
     * @param startNode The Node to begin at.
     * @param otherNodes Every other Node, with no specified end point.
     */
    public ShortestRoute(Node startNode, List<Node> otherNodes) {
	this(startNode, otherNodes, null);
    }
    
    /**
     * Creates a new instance of ShortestRoute.
     * 
     * @param otherNodes All of the Nodes apart from the last, with no specified
     * point of origin.
     * @param endNode The Node to end at.
     */

    public ShortestRoute(List<Node> otherNodes, Node endNode) {
	this(null, otherNodes, endNode);
    }
    
    /**
     * Creates a new instance of ShortestRoute.
     * 
     * @param startNode The Node to begin at.
     * @param otherNodes Every other Node apart from the last.
     * @param endNode The Node to end at.
     */
    public ShortestRoute(Node startNode, List<Node> otherNodes, Node endNode) {
	shortestRoutes = new ArrayList<List<Node>>();
	
	int possibleTime;
	List<Node> possibleRoute;
	
	HeapsAlgorithm allPermutations = new HeapsAlgorithm(otherNodes.size());
	
	possibleRoute = getPossibleRoute(0, allPermutations, startNode, otherNodes, endNode);
	shortestRoutes.add(possibleRoute);
	shortestTime = getPossibleTime(possibleRoute);
	numberOfRoutes = 1;
	
	for (int i = 1; i < allPermutations.getNumberOfPermutations(); i++) {
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
    
    /**
     * Method to return the number of routes that take the shortest amount of time.
     * 
     * @return The value as an int, greater than 1.
     */
    public int getNumberOfRoutes() {
	return numberOfRoutes;
    }
    
    /**
     * Getter method to return the specified shortest route through the nodes.
     * 
     * @param routeNumber the specified route, starting at index zero, must be less than
     * the number of routes.
     * @return The specified route, as a list of Nodes.
     */
    public List<Node> getRoute(int routeNumber) {
	if (routeNumber < numberOfRoutes && routeNumber >= 0) {
	    return shortestRoutes.get(routeNumber);
	} else {
	    throw new IndexOutOfBoundsException("routeNumber must be greater than "
	    	+ " or equal to zero, and less than " + numberOfRoutes + ".");
	}
	
    }
    
    /**
     * Getter method to return the time that the shortest route would take. Ignores how
     * long each individual node takes, looks only at the journey time between them all.
     * 
     * @return The shortest time, as an int.
     */
    public int getTime() {
	return shortestTime;
    }
    
    /**
     * private helper method to get the length of time it would take to travel through a
     * specified list of nodes in order.
     * 
     * @param possibleRoute the list of nodes to travel through.
     * @return the time, in minutes, as an int.
     */
    private int getPossibleTime(List<Node> possibleRoute) {
	int possibleTime = 0;
	for (int i = 0; i + 1 < possibleRoute.size(); i++) {
	    Node fromHere = possibleRoute.get(i);
	    Node toHere = possibleRoute.get(i + 1);
	    possibleTime += fromHere.getTimeTo(toHere);
	}
	return possibleTime;
    }
    
    /**
     * private helper method to return a possible route through a list of 
     * nodes, based on the order of the specified permutation of a list of 
     * every possible permutations.
     * 
     * @param permutationNumber the int permutation of allPermutations to run through
     * @param allPermutations the 
     * @param startNode
     * @param otherNodes
     * @param endNode
     * @return
     */
    private List<Node> getPossibleRoute(int permutationNumber, HeapsAlgorithm allPermutations, 
	    Node startNode, List<Node> otherNodes, Node endNode) {
	List<Node> possibleRoute = new ArrayList<Node>();
	if (startNode != null) {
	    possibleRoute.add(startNode);
	}
	for (int i = 0; i < allPermutations.getLengthOfList(); i++) {
	    int index = allPermutations.get(permutationNumber, i);
	    possibleRoute.add(otherNodes.get(index));
	}
	if (endNode !=null) {
	    possibleRoute.add(endNode);
	}
	return possibleRoute;
    }
}

