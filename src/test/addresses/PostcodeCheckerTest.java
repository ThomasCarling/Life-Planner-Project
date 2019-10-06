package addresses;

import static org.junit.Assert.*;

import org.junit.Test;

import addresses.PostcodeChecker;

public class PostcodeCheckerTest {

    @Test
    public void checkIsValidTest_returnValid() {
	assertTrue(PostcodeChecker.checkIsValid("M1 1AA"));
	assertTrue(PostcodeChecker.checkIsValid("M60 1NW"));
	assertTrue(PostcodeChecker.checkIsValid("CR2 6XH"));
	assertTrue(PostcodeChecker.checkIsValid("DN55 1PT"));
	assertTrue(PostcodeChecker.checkIsValid("W1A 1HQ"));
	assertTrue(PostcodeChecker.checkIsValid("EC1A 1BB"));
    }
    @Test
    public void  checkIsValidTest_wrongFormatButValid() {
	assertTrue(PostcodeChecker.checkIsValid("M11AA"));
	assertTrue(PostcodeChecker.checkIsValid("M  6 0 1    N   W    "));
	assertTrue(PostcodeChecker.checkIsValid("    CR2 6XH    "));
	assertTrue(PostcodeChecker.checkIsValid("DN551P T"));
	assertTrue(PostcodeChecker.checkIsValid("     w1a1Hq"));
	assertTrue(PostcodeChecker.checkIsValid("Ec1                A 1BB"));
    }
    @Test
    public void checkIsValidTest_invalidLetter() {
	assertFalse(PostcodeChecker.checkIsValid("Q1 1AA"));
	assertFalse(PostcodeChecker.checkIsValid("M60 1KW"));
	assertFalse(PostcodeChecker.checkIsValid("CR2 6XM"));
	assertFalse(PostcodeChecker.checkIsValid("DI55 1PT"));
	assertFalse(PostcodeChecker.checkIsValid("W1M 1HQ"));
	assertFalse(PostcodeChecker.checkIsValid("EC1U 1BB"));
    }
    @Test
    public void checkIsValidTest_postcodeTooLong() {
	assertFalse(PostcodeChecker.checkIsValid("DI556 1AA"));
	assertFalse(PostcodeChecker.checkIsValid("DI55 1AAB"));
    }
    @Test
    public void checkIsValidTest_postcodeTooShort() {
	assertFalse(PostcodeChecker.checkIsValid("D 1AA"));
	assertFalse(PostcodeChecker.checkIsValid("DI55 1"));
    }
    
    @Test
    public void checkIsValidTest_randomCharacters() {
	assertFalse(PostcodeChecker.checkIsValid("ME 1AA"));
	assertFalse(PostcodeChecker.checkIsValid("M6! 1NW"));
	assertFalse(PostcodeChecker.checkIsValid("CRT 6XH"));
	assertFalse(PostcodeChecker.checkIsValid("DN55 #PT"));
	assertFalse(PostcodeChecker.checkIsValid("W{A 1HQ"));
	assertFalse(PostcodeChecker.checkIsValid("EC!A 1BB"));
    }
}
