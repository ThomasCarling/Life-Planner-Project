package algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import algorithms.HeapsAlgorithm;

public class HeapsAlgorithmTest {

    @Test
    public void testCalculateNone() {
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

    }
    
    @Test
    public void testFactorial() {
	assertEquals(1, HeapsAlgorithm.factorial(0));
	assertEquals(1, HeapsAlgorithm.factorial(1));
	assertEquals(2, HeapsAlgorithm.factorial(2));
	assertEquals(6, HeapsAlgorithm.factorial(3));
	assertEquals(24, HeapsAlgorithm.factorial(4));

    }

    @Test
    public void testSwap() {
	int[] testList = {0, 1, 2, 3};
	HeapsAlgorithm.swap(testList, 1, 3);
	assertEquals("[0, 3, 2, 1]", Arrays.toString(testList));
	HeapsAlgorithm.swap(testList, 2, 1);
	assertEquals("[0, 2, 3, 1]", Arrays.toString(testList));
    }

}
