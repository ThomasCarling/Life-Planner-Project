package algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.HeapsAlgorithm;

public class HeapsAlgorithmTest {

    HeapsAlgorithm zero;
    HeapsAlgorithm one;
    HeapsAlgorithm two;
    HeapsAlgorithm three;
    HeapsAlgorithm four;
    int[] expectedRow;
    int actualInt;
    
    @Before
    public void setUp() throws Exception {
	zero = new HeapsAlgorithm(0);
	one = new HeapsAlgorithm(1);
	two = new HeapsAlgorithm(2);
	three = new HeapsAlgorithm(3);
	four = new HeapsAlgorithm(4);	
    }
    
    @After
    public void tearDown() throws Exception {
	zero = null;
	one = null;
	two = null;
	three = null;
	four = null;	
    }
    
    @Test
    public void testGetOrder_validRow() {
	
	//test four
	expectedRow = new int[] {0, 1, 2, 3};
	
	actualInt = four.get(0, 0);
	assertEquals(expectedRow[0], actualInt);
	actualInt = four.get(0, 1);
	assertEquals(expectedRow[1], actualInt);
	actualInt = four.get(0, 2);
	assertEquals(expectedRow[2], actualInt);
	actualInt = four.get(0, 3);
	assertEquals(expectedRow[3], actualInt);
	
	expectedRow = new int[] {1, 0, 2, 3};
	actualInt = four.get(1, 0);
	assertEquals(expectedRow[0], actualInt);
	actualInt = four.get(1, 1);
	assertEquals(expectedRow[1], actualInt);
	actualInt = four.get(1, 2);
	assertEquals(expectedRow[2], actualInt);
	actualInt = four.get(1, 3);
	assertEquals(expectedRow[3], actualInt);
	
	expectedRow = new int[] {3, 1, 0, 2};
	actualInt = four.get(6, 0);
	assertEquals(expectedRow[0], actualInt);
	actualInt = four.get(6, 1);
	assertEquals(expectedRow[1], actualInt);
	actualInt = four.get(6, 2);
	assertEquals(expectedRow[2], actualInt);
	actualInt = four.get(6, 3);
	assertEquals(expectedRow[3], actualInt);
	
	expectedRow = new int[] {0, 2, 3, 1};
	actualInt = four.get(12, 0);
	assertEquals(expectedRow[0], actualInt);
	actualInt = four.get(12, 1);
	assertEquals(expectedRow[1], actualInt);
	actualInt = four.get(12, 2);
	assertEquals(expectedRow[2], actualInt);
	actualInt = four.get(12, 3);
	assertEquals(expectedRow[3], actualInt);
	
	expectedRow = new int[] {1, 2, 3, 0};
	actualInt = four.get(23, 0);
	assertEquals(expectedRow[0], actualInt);
	actualInt = four.get(23, 1);
	assertEquals(expectedRow[1], actualInt);
	actualInt = four.get(23, 2);
	assertEquals(expectedRow[2], actualInt);
	actualInt = four.get(23, 3);
	assertEquals(expectedRow[3], actualInt);
    }
    
    /*@Test
    public void testCalculateNone() {
	HeapsAlgorithm test
	int[] testList = {};
	int[][] result = HeapsAlgorithm.calculate(testList);
	assertEquals("null", Arrays.toString(result));
    }
    @Test
    public void testCalculateOne() {
	int[] testList = {1};
	int[][] result = HeapsAlgorithm.calculate(testList);
	assertEquals("[1]", Arrays.toString(result[0]));
    }
    @Test
    public void testCalculateTwo() {
	int[] testList = {1, 2};
	int[][] result = HeapsAlgorithm.calculate(testList);
	assertEquals("[1, 2]", Arrays.toString(result[0]));
	assertEquals("[2, 1]", Arrays.toString(result[1]));

    }@Test
    public void testCalculateThree() {
	int[] testList = {1, 2, 3};
	int[][] result = HeapsAlgorithm.calculate(testList);
	assertEquals("[1, 2, 3]", Arrays.toString(result[0]));
	assertEquals("[2, 1, 3]", Arrays.toString(result[1]));
	assertEquals("[3, 1, 2]", Arrays.toString(result[2]));
	assertEquals("[1, 3, 2]", Arrays.toString(result[3]));
	assertEquals("[2, 3, 1]", Arrays.toString(result[4]));
	assertEquals("[3, 2, 1]", Arrays.toString(result[5]));

    }
    
    @Test
    public void testCalculateFour() {
	int[] testList = {1, 2, 3, 4};
	int[][] result = HeapsAlgorithm.calculate(testList);
	assertEquals("[1, 2, 3, 4]", Arrays.toString(result[0]));
	assertEquals("[2, 1, 3, 4]", Arrays.toString(result[1]));
	assertEquals("[3, 1, 2, 4]", Arrays.toString(result[2]));
	assertEquals("[1, 3, 2, 4]", Arrays.toString(result[3]));
	assertEquals("[2, 3, 1, 4]", Arrays.toString(result[4]));
	assertEquals("[3, 2, 1, 4]", Arrays.toString(result[5]));
	assertEquals("[4, 2, 1, 3]", Arrays.toString(result[6]));
	assertEquals("[2, 4, 1, 3]", Arrays.toString(result[7]));
	assertEquals("[1, 4, 2, 3]", Arrays.toString(result[8]));
	assertEquals("[4, 1, 2, 3]", Arrays.toString(result[9]));
	assertEquals("[2, 1, 4, 3]", Arrays.toString(result[10]));
	assertEquals("[1, 2, 4, 3]", Arrays.toString(result[11]));
	assertEquals("[1, 3, 4, 2]", Arrays.toString(result[12]));
	assertEquals("[3, 1, 4, 2]", Arrays.toString(result[13]));
	assertEquals("[4, 1, 3, 2]", Arrays.toString(result[14]));
	assertEquals("[1, 4, 3, 2]", Arrays.toString(result[15]));
	assertEquals("[3, 4, 1, 2]", Arrays.toString(result[16]));
	assertEquals("[4, 3, 1, 2]", Arrays.toString(result[17]));
	assertEquals("[4, 3, 2, 1]", Arrays.toString(result[18]));
	assertEquals("[3, 4, 2, 1]", Arrays.toString(result[19]));
	assertEquals("[2, 4, 3, 1]", Arrays.toString(result[20]));
	assertEquals("[4, 2, 3, 1]", Arrays.toString(result[21]));
	assertEquals("[3, 2, 4, 1]", Arrays.toString(result[22]));
	assertEquals("[2, 3, 4, 1]", Arrays.toString(result[23]));

    } */
}
