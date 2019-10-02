package addresses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import addresses.PostcodeChecker;

public class PostcodeCheckerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCheck() {
	assertTrue(PostcodeChecker.check("M1 1AA"));
	assertTrue(PostcodeChecker.check("M60 1NW"));
	assertTrue(PostcodeChecker.check("CR2 6XH"));
	assertTrue(PostcodeChecker.check("DN55 1PT"));
	assertTrue(PostcodeChecker.check("W1A 1HQ"));
	assertTrue(PostcodeChecker.check("EC1A 1BB"));
	assertTrue(PostcodeChecker.check("EC1A1BB"));

	
	assertTrue(PostcodeChecker.check(" me19    6aj "));
	assertTrue(PostcodeChecker.check(" ec1Y  4sB "));

	assertFalse(PostcodeChecker.check("Q1 1AA"));
	assertFalse(PostcodeChecker.check("DN55 1KM"));
	assertFalse(PostcodeChecker.check("1MM 1PT"));
	assertFalse(PostcodeChecker.check("1MMTJ 1PT"));
	assertFalse(PostcodeChecker.check("1MMTJ 1PJT"));
	assertFalse(PostcodeChecker.check("1MJ 1PHT"));
	assertFalse(PostcodeChecker.check("Hello, I'm a postcode"));
    }
    
    @Test
    public void testFixOne() {
	assertEquals("E8 2JP", PostcodeChecker.fix("e 82   J P"));

	assertEquals("ME19 6AJ", PostcodeChecker.fix("M E1 96 aJ"));

    }
    
    @Test 
    public void testGetSubstring() {
	assertEquals("1234", PostcodeChecker.getSubstring("1234 5678", true));
	assertEquals("5678", PostcodeChecker.getSubstring("1234 5678", false));
	assertEquals("qwivr", PostcodeChecker.getSubstring("qwivr  rfrk fc", true));
	assertEquals(" rfrk fc", PostcodeChecker.getSubstring("qwivr  rfrk fc", false));
    }
    
    @Test 
    public void testCheckLength() {
	assertTrue(PostcodeChecker.checkLength("12", true));
	assertTrue(PostcodeChecker.checkLength("123", true));
	assertTrue(PostcodeChecker.checkLength("1243", true));
	assertTrue(PostcodeChecker.checkLength("123", false));

	assertFalse(PostcodeChecker.checkLength("1", true));
	assertFalse(PostcodeChecker.checkLength("1574f", true));
	assertFalse(PostcodeChecker.checkLength("dh", false));
	assertFalse(PostcodeChecker.checkLength("2fwv", false));


    }
    @Test
    public void testNumberCheck() {
	assertTrue(PostcodeChecker.numberCheck("1"));
	assertTrue(PostcodeChecker.numberCheck("7"));
	assertTrue(PostcodeChecker.numberCheck("5"));
	assertTrue(PostcodeChecker.numberCheck("4"));

	assertFalse(PostcodeChecker.numberCheck("t"));
	assertFalse(PostcodeChecker.numberCheck("j"));
	assertFalse(PostcodeChecker.numberCheck("!"));
	assertFalse(PostcodeChecker.numberCheck("'"));

    }
    @Test 
    public void testLetterCheck() {
	assertTrue(PostcodeChecker.letterCheck("T"));
	assertTrue(PostcodeChecker.letterCheck("J"));
	assertTrue(PostcodeChecker.letterCheck("w"));
	assertTrue(PostcodeChecker.letterCheck("a"));

	assertFalse(PostcodeChecker.letterCheck("t", "ajt"));
	assertFalse(PostcodeChecker.letterCheck("4"));
	assertFalse(PostcodeChecker.letterCheck("/"));
	assertFalse(PostcodeChecker.letterCheck("e", "abcde"));

    }

    @Test
    public void testCanFix() {
	assertTrue(PostcodeChecker.canFix("E82", "JP"));
	assertTrue(PostcodeChecker.canFix("E   82  J", "P"));
	assertTrue(PostcodeChecker.canFix("E", "82JP"));

	assertFalse(PostcodeChecker.canFix("mdeE", "82JP"));
	assertFalse(PostcodeChecker.canFix("E888", "82JP"));
	assertFalse(PostcodeChecker.canFix("E", "2JP"));

    }
    
    @Test
    public void testFixTwo() {
	assertEquals("E8", PostcodeChecker.fix("E", "82   J P", true));
	assertEquals("2JP", PostcodeChecker.fix("E", "82   J P", false));

	assertEquals("ME19", PostcodeChecker.fix("M E1", "96 AJ", true));
	assertEquals("6AJ", PostcodeChecker.fix("M E1", "96 AJ", false));

    }
    
    @Test
    public void TestCheckSecondHalf() {
	assertTrue(PostcodeChecker.checkSecondHalf("1AA"));
	assertTrue(PostcodeChecker.checkSecondHalf("1NW"));
	assertTrue(PostcodeChecker.checkSecondHalf("1PT"));
	assertTrue(PostcodeChecker.checkSecondHalf("1HQ"));

	assertFalse(PostcodeChecker.checkSecondHalf("1CB"));
	assertFalse(PostcodeChecker.checkSecondHalf("ACB"));
	assertFalse(PostcodeChecker.checkSecondHalf("6XM"));
	assertFalse(PostcodeChecker.checkSecondHalf("6X!"));


    }
    
    @Test
    public void testCheckFirstHalf() {
	
    }
}
