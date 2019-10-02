package test.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import oldmain.addresses.Address;
import oldmain.algorithms.ShortestRoute;
import oldmain.datastorage.AddressStore;
import oldmain.datastorage.EventStore;
import oldmain.events.Event;

public class ShortestRouteTest {

    private Event first;
    private Event second;
    private Event third;
    private Event fourth;
    private Event fifth;
    
    private EventStore allEvents;
    private AddressStore allDistances;
    private ShortestRoute routeTest;
    
    @Before
    public void setUp() throws Exception {
	first = new Event("cook dinner", "E8 2JP", 30);
	second = new Event("shopping", "N1 3PB", 30);
	third = new Event("Library", "ME19 6AJ", 20);
	fourth = new Event("visit friends", "EC1Y 4SB", 60);
	fifth = new Event("Go to cinema", "YO19 6PB", 100);
	//all of this stuff will be done more snazzily at a later stage
	// written it like this so that it won't break if the later stages break
	Address one = new Address(first.getPostcode());
	Address two = new Address(second.getPostcode());
	Address three = new Address(third.getPostcode());
	Address four = new Address(fourth.getPostcode());
	Address five = new Address(fifth.getPostcode());
	one.addDistance(10, "N1 3PB");
	one.addDistance(5, "ME19 6AJ");
	one.addDistance(30, "EC1Y 4SB");
	one.addDistance(15, "YO19 6PB");
	two.addDistance(13, "E8 2JP");
	two.addDistance(7, "ME19 6AJ");
	two.addDistance(35, "EC1Y 4SB");
	two.addDistance(8, "YO19 6PB");
	three.addDistance(6, "E8 2JP");
	three.addDistance(3, "N1 3PB");
	three.addDistance(40, "EC1Y 4SB");
	three.addDistance(20, "YO19 6PB");
	four.addDistance(35, "E8 2JP");
	four.addDistance(30, "N1 3PB");
	four.addDistance(40, "ME19 6AJ");
	four.addDistance(45, "YO19 6PB");
	five.addDistance(14, "E8 2JP");
	five.addDistance(3, "N1 3PB");
	five.addDistance(15, "ME19 6AJ");
	five.addDistance(35, "EC1Y 4SB");
	
	allEvents = new EventStore("testEvent.ser");
	allDistances = new AddressStore("testDistances.ser");
	
	allEvents.add(first);
	allEvents.add(second);
	allEvents.add(third);
	allEvents.add(fourth);
	allEvents.add(fifth);
	
	allDistances.add(one);
	allDistances.add(two);
	allDistances.add(three);
	allDistances.add(four);
	allDistances.add(five);	

    }

    @After
    public void tearDown() throws Exception {
	first = null;
	second = null;
	third = null;
	fourth = null;
	fifth = null;
    }
    
    @Test
    public void testCalculateAllCombinationsTwo() {
	assertEquals("[0, 1]", Arrays.toString(ShortestRoute.calculateAllCombinations(2)[0]));
    }
    @Test
    public void testCalculateAllCombinationsThree() {
	assertEquals("[0, 1, 2]", Arrays.toString(ShortestRoute.calculateAllCombinations(3)[0]));
    }
    @Test
    public void testCalculateAllCombinationsFour() {
	assertEquals("[0, 1, 2, 3]", Arrays.toString(ShortestRoute.calculateAllCombinations(4)[0]));
	assertEquals("[0, 2, 1, 3]", Arrays.toString(ShortestRoute.calculateAllCombinations(4)[1]));

    }
    @Test
    public void testCalculateAllCombinationsFive() {
	assertEquals("[0, 1, 2, 3, 4]", Arrays.toString(ShortestRoute.calculateAllCombinations(5)[0]));
	assertEquals("[0, 2, 1, 3, 4]", Arrays.toString(ShortestRoute.calculateAllCombinations(5)[1]));
	assertEquals("[0, 3, 1, 2, 4]", Arrays.toString(ShortestRoute.calculateAllCombinations(5)[2]));
	assertEquals("[0, 1, 3, 2, 4]", Arrays.toString(ShortestRoute.calculateAllCombinations(5)[3]));
	assertEquals("[0, 2, 3, 1, 4]", Arrays.toString(ShortestRoute.calculateAllCombinations(5)[4]));
	assertEquals("[0, 3, 2, 1, 4]", Arrays.toString(ShortestRoute.calculateAllCombinations(5)[5]));
	}
    
    @Test 
    public void testGetDistances() {
	routeTest = new ShortestRoute(allDistances, first, fifth, second, third, fourth);

	assertEquals("[0, 10, 5, 30, 15]", Arrays.toString(routeTest.getDistances()[0]));
	assertEquals("[13, 0, 7, 35, 8]", Arrays.toString(routeTest.getDistances()[1]));
	assertEquals("[6, 3, 0, 40, 20]", Arrays.toString(routeTest.getDistances()[2]));
	assertEquals("[35, 30, 40, 0, 45]", Arrays.toString(routeTest.getDistances()[3]));
	assertEquals("[14, 3, 15, 35, 0]", Arrays.toString(routeTest.getDistances()[4]));
    }

    @Test
    public void testGetRoute() {
	routeTest = new ShortestRoute(allDistances, first, second, third);
	assertEquals("cook dinner",routeTest.getRoute()[0].getName());
	assertEquals("Library",routeTest.getRoute()[1].getName());
	assertEquals("shopping",routeTest.getRoute()[2].getName());
    }
    
    @Test 
    public void testGetAnotherRoute() {
	routeTest = new ShortestRoute(allDistances, first, second);
	assertEquals("cook dinner",routeTest.getRoute()[0].getName());
	assertEquals("shopping",routeTest.getRoute()[1].getName());
	
    }
    @Test
    public void testGetMoreComplicatedRoute() {
	
	routeTest = new ShortestRoute(allDistances, first, fourth, second, third);
	assertEquals("cook dinner",routeTest.getRoute()[0].getName());
	assertEquals("Library",routeTest.getRoute()[1].getName());
	assertEquals("shopping",routeTest.getRoute()[2].getName());
	assertEquals("visit friends",routeTest.getRoute()[3].getName());
    }
    @Test
    public void testGetReallyComplicatedRoute() {
	routeTest = new ShortestRoute(allDistances, first, fifth, second, third, fourth);
	assertEquals("cook dinner",routeTest.getRoute()[0].getName());
	assertEquals("visit friends",routeTest.getRoute()[1].getName());
	assertEquals("Library",routeTest.getRoute()[2].getName());
	assertEquals("shopping",routeTest.getRoute()[3].getName());
	assertEquals("Go to cinema",routeTest.getRoute()[4].getName());
    }

    @Test
    public void testGetTime() {
	routeTest = new ShortestRoute(allDistances, first, fifth, second, third, fourth);
	assertEquals(81, routeTest.getTime());
	routeTest = new ShortestRoute(allDistances, first, fourth, second, third);
	assertEquals(43, routeTest.getTime());
    }
}
