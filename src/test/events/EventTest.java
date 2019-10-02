package events;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import events.Event;


public class EventTest {
    private Event first;
    private Event second;
    private Event third;

    private ArrayList<LocalDateTime> days;

    private LocalDateTime one;
    private LocalDateTime two;
    private LocalDateTime three;



    @Before
    public void setUp() throws Exception {
	first = new Event("Work", "E8 2JP", 480);
	second = new Event("Shopping", "N1 3PB", 30);
	third = new Event("read", "ME19 6AJ", 40);

	days = new ArrayList<LocalDateTime>();

	one = LocalDateTime.of(2019, 9, 10, 12, 0);
	two = LocalDateTime.of(2019, 9, 11, 12, 30);
	three = LocalDateTime.of(2019, 9, 11, 13, 15);

	days.add(one);
	days.add(two);
	days.add(three);



    }

    @After
    public void tearDown() {
	first = null;
	second = null;
	third = null;
	one = null;
	two = null;
	three = null;
	days = null;
    }

    @Test
    public void testChangeAndGetName() {
	first.changeName("not work");
	assertEquals("not work", first.getName());
    }
    @Test
    public void testSetAndGetDetails() {
	first.setDetails("Here are some details");
	assertEquals("Here are some details", first.getDetails());
    }

    @Test
    public void testSetAndGetPostcode() {
	assertEquals("E8 2JP",first.getPostcode());
	assertEquals("N1 3PB",second.getPostcode());
	assertEquals("ME19 6AJ",third.getPostcode());
	first.setPostcode("E9 3JP");
	assertEquals("E9 3JP",first.getPostcode());
    }

    @Test
    public void testSetLength() {
	first.setLength(57);
	assertEquals(57, first.getLength());
    }

    @Test
    public void testGetLength() {
	assertEquals(480, first.getLength());
	assertEquals(30, second.getLength());
	assertEquals(40, third.getLength());
    }

    @Test
    public void testEqualsObject() {
	assertTrue(first.equals(first));
	assertFalse(first.equals(second));
	assertFalse(first.equals(third));

	assertFalse(second.equals(first));
	assertTrue(second.equals(second));
	assertFalse(second.equals(third));

	assertFalse(third.equals(first));
	assertFalse(third.equals(second));
	assertTrue(third.equals(third));
    }
    
    @Test
    public void testSetAndGetFixedTime() {
	first.setFixedTime(one);
	second.setFixedTime(two);
	third.setFixedTime(three);
	assertTrue(first.getFixedTime().equals(one));
	assertTrue(second.getFixedTime().equals(two));
	assertTrue(third.getFixedTime().equals(three));
    }
    
    @Test
    public void testSetAndGetAssignedTime() {
	first.setAssignedTime(one);
	second.setAssignedTime(two);
	third.setAssignedTime(three);
	assertTrue(first.getAssignedTime().equals(one));
	assertTrue(second.getAssignedTime().equals(two));
	assertTrue(third.getAssignedTime().equals(three));
    }
}
