package algorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import addresses.Address;
import algorithms.ShortestRoute;
import dataStorage.AddressStore;
import dataStorage.EventStore;
import events.Event;

public class ShortestRouteTest {
    
    private List<Node> allNodes;
    private ShortestRoute routeTest;
    
    private MockNode first;
    private MockNode second;
    private MockNode third;
    private MockNode fourth;
    private MockNode fifth;
    
    @Before
    public void setUp() throws Exception {
	first = new MockNode("E8 2JP");
	second = new MockNode("N1 3PB");
	third = new MockNode("ME19, 6AJ");
	fourth = new MockNode("EC1Y 4SB");
	fifth = new MockNode("YO19 6PB");
	
	first.setTimeTo(second, 10);
	first.setTimeTo(third, 5);
	first.setTimeTo(fourth, 30);
	first.setTimeTo(fifth, 15);
	second.setTimeTo(first, 13);
	second.setTimeTo(third, 7);
	second.setTimeTo(fourth, 35);
	second.setTimeTo(fifth, 8);
	third.setTimeTo(first, 6);
	third.setTimeTo(second, 3);
	third.setTimeTo(fourth, 40);
	third.setTimeTo(fifth, 20);
	fourth.setTimeTo(first, 35);
	fourth.setTimeTo(second, 30);
	fourth.setTimeTo(third, 40);
	fourth.setTimeTo(fifth, 45);
	fifth.setTimeTo(first, 14);
	fifth.setTimeTo(second, 3);
	fifth.setTimeTo(third, 15);
	fifth.setTimeTo(fifth, 35);
	
	allNodes = new ArrayList<Node>(5);
    }

    @After
    public void tearDown() throws Exception {
	allNodes = null;
	routeTest = null;
	first = null;
	second = null;
	third = null;
	fourth = null;
	fifth = null;
    }
    
    @Test 
    public void testNumberOfRoutes_TwoFixedNodes() {
	routeTest = new ShortestRoute(first, allNodes, second);
	int numberOfRoutes = routeTest.getNumberOfRoutes();
	assertEquals(1, numberOfRoutes);
    }
    
    @Test 
    public void testNumberOfRoutes_OneFixedStartOneFloatingNode() {
	allNodes.add(second);
	routeTest = new ShortestRoute(first, allNodes);
	int numberOfRoutes = routeTest.getNumberOfRoutes();
	assertEquals(1, numberOfRoutes);
    }

    @Test 
    public void testNumberOfRoutes_OneFloatingOneFixedEndNode() {
	allNodes.add(first);
	routeTest = new ShortestRoute(allNodes, second);
	int numberOfRoutes = routeTest.getNumberOfRoutes();
	assertEquals(1, numberOfRoutes);
    }
    

    @Test 
    public void testNumberOfRoutes_TwoFloatingNodes() {
	allNodes.add(first);
	allNodes.add(second);
	routeTest = new ShortestRoute(allNodes);
	int numberOfRoutes = routeTest.getNumberOfRoutes();
	assertEquals(1, numberOfRoutes);
    }
   /* @Test
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
    }*/
}
