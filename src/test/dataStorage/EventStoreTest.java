package dataStorage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataStorage.EventStore;
import events.Event;


public class EventStoreTest {
    
    private EventStore testList;
    private Event first;
    private Event second;
    private Event third;
    
    @Before
    public void setUp() throws Exception {
	testList = new EventStore("testEventStore.ser");
	first = new Event("Work", "E8 2JP", 480);
	second = new Event("Shopping", "EC1Y 4SB",30);
	third = new Event("read", "ME19 6AJ", 40);
    }

    @After
    public void tearDown() throws Exception {
	first = null;
	second = null;
	third = null;
	testList = null;
    }

    @Test
    public void testAdd() {
	assertEquals(0, testList.size());
	testList.add(first);
	assertEquals(1, testList.size());
	testList.add(second);
	assertEquals(2, testList.size());
	testList.add(third);
	assertEquals(3, testList.size());

    }

    @Test
    public void testRemove() {
	testList.add(first);
	testList.add(second);
	testList.add(third);
	assertEquals(3, testList.size());
	testList.remove(first);
	assertEquals(2, testList.size());
	testList.remove(second);
	assertEquals(1, testList.size());
	testList.remove(third);
	assertEquals(0, testList.size());    
	}

    @Test
    public void testSaveAndLoad() {
	testList.add(first);
	testList.save();
	testList.clearMemory();
	testList.load();
	assertTrue(testList.get(0).equals(first));
	testList.add(second);
	testList.save();
	testList.clearMemory();
	testList.load();
	assertTrue(testList.get(1).equals(second));
	
    }
    
    @Test
    public void testSize() {
	assertEquals(0, testList.size());
	testList.add(first);
	assertEquals(1, testList.size());
	testList.add(second);
	assertEquals(2, testList.size());
	testList.add(third);
	assertEquals(3, testList.size());
    }

    @Test
    public void testClearMemory() {
	testList.add(first);
	testList.add(second);
	testList.clearMemory();
	assertEquals(0, testList.size());
    }
    
    @Test
    public void testGet() {
	testList.add(first);
	testList.add(second);
	testList.add(third);
	assertTrue(testList.get(0).equals(first));
	assertTrue(testList.get(1).equals(second));
	assertTrue(testList.get(2).equals(third));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionRemove() {
	testList.remove(first);
    }
}
