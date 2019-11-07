package algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import algorithms.HeapsAlgorithm;

public class HeapsAlgorithmTest {
    
    @Test
    public void testGetOrder_validRowOf4() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(4);
	
	int[] expectedRow = new int[] {0, 1, 2, 3};
	int[] actualRow = testHeap.getRow(0);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {1, 0, 2, 3};
	actualRow = testHeap.getRow(1);
	assertTrue(Arrays.equals(expectedRow, actualRow));

	expectedRow = new int[] {3, 1, 0, 2};
	actualRow = testHeap.getRow(6);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {0, 2, 3, 1};
	actualRow = testHeap.getRow(12);
	assertTrue(Arrays.equals(expectedRow, actualRow));

	expectedRow = new int[] {1, 2, 3, 0};
	actualRow = testHeap.getRow(23);
	assertTrue(Arrays.equals(expectedRow, actualRow));
    }
    
    @Test
    public void testGetOrder_ValidRowOf3() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(3);
	
	int[] expectedRow = new int[] {0, 1, 2};
	int[] actualRow = testHeap.getRow(0);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {1, 0, 2};
	actualRow = testHeap.getRow(1);
	assertTrue(Arrays.equals(expectedRow, actualRow));

	expectedRow = new int[] {2, 0, 1};
	actualRow = testHeap.getRow(2);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {0, 2, 1};
	actualRow = testHeap.getRow(3);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {1, 2, 0};
	actualRow = testHeap.getRow(4);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {2, 1, 0};
	actualRow = testHeap.getRow(5);
	assertTrue(Arrays.equals(expectedRow, actualRow));
    }

    @Test
    public void testGetOrder_ValidRowOf2() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(2);
	
	int[] expectedRow = new int[] {0, 1};
	int[] actualRow = testHeap.getRow(0);
	assertTrue(Arrays.equals(expectedRow, actualRow));
	
	expectedRow = new int[] {1, 0};
	actualRow = testHeap.getRow(1);
	assertTrue(Arrays.equals(expectedRow, actualRow));

    }

    @Test
    public void testGetOrder_ValidRowOf1() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(1);
	
	int[] expectedRow = new int[] {0};
	int[] actualRow = testHeap.getRow(0);
	assertTrue(Arrays.equals(expectedRow, actualRow));
    }

    @Test
    public void testGetOrder_0ReturnNull() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(0);
	
	int[] expectedRow = null;
	int[] actualRow = testHeap.getRow(0);
	assertTrue(Arrays.equals(expectedRow, actualRow));
    }
    

    @Test (expected = IllegalArgumentException.class)
    public void testGetOrder_TooHighIndex() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(2);
	testHeap.get(1, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetOrder_TooLowIndex() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(2);
	testHeap.get(1, -5);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testGetOrder_TooHighPermutation() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(2);
	testHeap.getRow(2);
    }
   
    @Test (expected = IllegalArgumentException.class)
    public void testGetOrder_TooLowPermutation() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(2);
	testHeap.getRow(-1);
    }
    
    @Test 
    public void testGetLengthOfList_0() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(0);
	
	int expectedLength = 0;
	int actualLength = testHeap.getLengthOfList();
	
	assertEquals(expectedLength, actualLength);
    }
    
    @Test 
    public void testGetLengthOfList_other() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(2);
	
	int expectedLength = 2;
	int actualLength = testHeap.getLengthOfList();
	
	assertEquals(expectedLength, actualLength);
	
	testHeap = new HeapsAlgorithm(14);
	expectedLength = 14;
	actualLength = testHeap.getLengthOfList();
	
	assertEquals(expectedLength, actualLength);
    }
    
    @Test 
    public void testGetNumberOfPermutations_zero() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(0);
	
	int expectedLength = 0;
	int actualLength = testHeap.getLengthOfList();
	
	assertEquals(expectedLength, actualLength);
    }
    
    @Test 
    public void testGetNumberOfPermutations_other() {
	HeapsAlgorithm testHeap = new HeapsAlgorithm(3);
	
	int expectedLength = 6;
	int actualLength = testHeap.getLengthOfList();
	
	assertEquals(expectedLength, actualLength);
	

	testHeap = new HeapsAlgorithm(6);
	expectedLength = 720;
	actualLength = testHeap.getLengthOfList();
	
	assertEquals(expectedLength, actualLength);
    }
    
}
