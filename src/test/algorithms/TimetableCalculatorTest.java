package algorithms;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import events.Event;

public class TimetableCalculatorTest {
    ArrayList<Event> test1;
    Event one;
    Event two;
    Event three;
    Event four;

    @Before
    public void setUp() throws Exception {
	test1 = new ArrayList<Event>();
	one = new Event("Shopping", "E8 2JP", 15);
	two = new Event("Work", "N1 3PB", 480);
	three = new Event("See Friends", "ME19 6AJ", 60);
	four = new Event("Breakfast", "E1 4SB", 30);
	
	one.setFixedTime(LocalDateTime.of(2019, 9, 10, 8, 30));
	three.setFixedTime(LocalDateTime.of(2019, 9, 10, 17, 30));
	four.setFixedTime(LocalDateTime.of(2019, 9, 10, 7, 15));
	
	test1.add(one);
	test1.add(two);
	test1.add(three);
	test1.add(four);
	
    }

    @After
    public void tearDown() throws Exception {
	test1 = null;
	one = null;
	two = null;
	three = null;
	four = null;
    }

    @Test
    public void testCalculate() {
	fail("Not yet implemented"); // TODO
    }

    @Test
    public void testGetFloatingOrSetEvents() {
	ArrayList<Event> test2 = TimetableCalculator.getFloatingOrSetEvents(test1, true);
	assertTrue(test2.get(0).equals(two));
	ArrayList<Event> test3 = TimetableCalculator.getFloatingOrSetEvents(test1, false);
	assertTrue(test3.get(0).equals(one));
    }
    
    @Test
    public void testSortByFixedTime() {
	test1.remove(two);
	test1 = TimetableCalculator.sortBySetTime(test1);
	assertTrue(test1.get(0).equals(four));
	assertTrue(test1.get(1).equals(one));
	assertTrue(test1.get(2).equals(three));
    }

}
