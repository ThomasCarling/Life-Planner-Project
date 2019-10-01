package lifeplannerproject.algorithms;

import lifeplannerproject.datastorage.AddressStore;
import lifeplannerproject.events.Event;

// class to find shortest route between a number of nodes, starting at one, ending at another, and visiting every point.

public class ShortestRoute {

    private AddressStore distances;
    private Event[] everyNode;
    
    private int[][] everyCombo;
    private int[][] distanceGrid;
    
    private Event[] shortestRoute;
    private int shortestTime;

    public ShortestRoute(AddressStore distances, Event start, Event end, Event... otherNodes) {
	
	this.distances = distances;
	
	
	//assigning everyNode, with "start" first, "end" last, and "otherNodes" in the middle.
	this.everyNode = new Event[otherNodes.length + 2];
	this.everyNode[0] = start;
	this.everyNode[everyNode.length - 1] = end;
	for(int i = 0; i < otherNodes.length; i++) {
	    this.everyNode[i + 1] = otherNodes[i];
	}
	
	// int list of every combination, corresponding to index in "everyNode" variable
	this.everyCombo = calculateAllCombinations(this.everyNode.length);
	
	//grid that contains distance from every node to every other node
	// eg distanceGrid[2][3] is the distance from node 2 to node 3
	this.distanceGrid = getDistances();
	
	//method that sets shortestRoute and shortestTime
	calculateShortestCombination();
	
    }

    // helper methods

    
    // method to calculate every combination of indices, with startNode first and endNode last
    
    protected static int[][] calculateAllCombinations(int length) {
	int[] sublist = new int[length - 2];
	for (int i = 0; i < length - 2; i++) {
	    sublist[i] = i + 1;
	}
	
	//calculate size of "result", which is the number of combos and length of each individual combo
	int[][] result = new int[HeapsAlgorithm.factorial(length - 2)][length];
	
	//pop in 0 for index 0 and last value for last index
	for (int i = 0; i < result.length; i++) {
	    result[i][0] = 0;
	    result[i][result[i].length - 1] = result[i].length - 1;
	}
	
	//get all combinations of sublist, using Heap's algorithm.
	int[][] subCombos = HeapsAlgorithm.calculate(sublist);
	
	// and insert into result 
	if (subCombos == null) {
	    return result;
	}
	for (int i = 0; i < subCombos.length; i++) {
	    for (int j = 0; j < subCombos[i].length; j++) {
		result[i][j + 1] = subCombos[i][j];
	    }
	}
	return result;
    }
    
    
    //method to put distances from each Event to each other Event into two dimensional array
    
    protected int[][] getDistances() {
	
	String fromPostcode;
	String toPostcode;
	
	int[][] result = new int[everyNode.length][everyNode.length];
	
	for (int i = 0; i < everyNode.length; i++) {
	    fromPostcode = everyNode[i].getPostcode();
	    
	    for (int j = 0; j < everyNode.length; j++) {
		toPostcode = everyNode[j].getPostcode();
		
		result[i][j] = distances.get(fromPostcode).getDistance(toPostcode);
	    }
	}
	return result;
    }
    
    //method to calculate shortest route
    
    private void calculateShortestCombination() {
	int resultIndex = 0;
	int shortestTime = 1000000;
	
	Event[] result = new Event[everyNode.length];
	int tryTime;
	
	for (int i = 0; i < everyCombo.length; i++) {
	    tryTime = 0;
	    for (int j = 0; j + 1 < everyCombo[i].length; j++) {
		tryTime += distanceGrid[everyCombo[i][j]][everyCombo[i][j + 1]];
	    }
	    if (tryTime < shortestTime) {
		shortestTime = tryTime;
		resultIndex = i;
	    }
	}
	
	for (int i = 0; i < everyNode.length; i++) {
	    result[i] = everyNode[everyCombo[resultIndex][i]];
	}
	shortestRoute = result;
	this.shortestTime = shortestTime;
    }
    
    public Event[] getRoute() {
	return shortestRoute;
    }
    public int getTime() {
	return shortestTime;
    }  
}

