package addresses;

public class PostcodeChecker {

    /**
     * Method to check the validity of a given postcode, based on the <a href = 
     * https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom#Formatting>wikipedia entry</a> 
     * for the Formatting of postcodes in the United Kingdom, correct as of 20:54 GMT+1 on 03/10/2019.
     * 
     * 
     * @param postcode the postcode to check.
     * @return true if valid, false if invalid.
     */
    public static boolean checkIsValid(String postcode) {

	correctFormat(postcode);

	/* check that postcode is between 6 and 8 characters long */
	if (postcode.length() < 6 || postcode.length() > 8) {
	    return false;
	}

	/* variable to store every valid number */
	String validNumber = "0123456789"; 

	/* Split the postcode into it's two main component parts, the 
	 * "Outward Code", or the first 2 to 4 characters placed before 
	 * the space, and the "Inward Code", the last three characters 
	 * after the space. */
	String outwardCode = postcode.substring(0, postcode.length() - 4);
	String inwardCode = postcode.substring(postcode.length() - 3);

	/* Split inwardCode into it's componenents, the Sector (first
	 *  character, should be a single digit) and the Unit (last two
	 *  characters, should be two letters, excluding C, I, K, M, O, 
	 *  and V) */
	String sector = inwardCode.substring(0, 1);
	String unit = inwardCode.substring(1);

	/* Then check them both*/
	if (!validNumber.contains(sector) || !checkLetter(unit, "CIKMOV")) {
	    return false;
	}

	/* a few variables, to make manipulating the individual characters in outwardCode
	 * clearer as we progress */
	String outwardCodeChar1 = outwardCode.substring(0,1);
	String outwardCodeChar2 = outwardCode.substring(1, 2);
	String outwardCodeChar3;
	String outwardCodeChar4;

	/* The first character of the outwardCode is always a letter, excluding
	 * Q, V, and X. */
	if (!checkLetter(outwardCodeChar1, "QVX")) {
	    return false;
	}

	/* now it get's slightly more convoluted, with several different possible
	 * formats depending on the length of the outward code. */
	switch (outwardCode.length()) {

	/* In this case, the only valid value for the second character 
	 * is a digit */
	case 2 : 
	    return validNumber.contains(outwardCodeChar2) ? true : false;

	case 3 : 
	    outwardCodeChar3 = outwardCode.substring(2, 3);

	    /* Here, if the second character is a letter (excluding I, J, and Z) 
	     * then the last character must be a number. */
	    if (checkLetter(outwardCodeChar2, "IJZ")) {
		return validNumber.contains(outwardCodeChar3) ? true : false;

		/* and if it's a number then the last character can be a number or a 
		 * letter excluding I, L, M, N, O, Q, R, V, X, Y, and Z. */
	    } else if (validNumber.contains(outwardCodeChar2)) {
		return validNumber.contains(outwardCodeChar3) || checkLetter(outwardCodeChar3, "ILMNOQRVXYZ") 
			? true : false;
	    } else {
		return false;
	    }

	case 4 : 
	    outwardCodeChar3 = outwardCode.substring(2, 3);
	    outwardCodeChar4 = outwardCode.substring(3, 4);

	    /* In this case, the second character must be a letter excluding I, J,
	     * and Z, and the third character a number. */
	    if (!checkLetter(outwardCodeChar2, "IJZ") || !validNumber.contains(outwardCodeChar3)) {
		return false;
	    } else {
		
		/* The last character must be a number, or a letter excluding a long 
		 * list I can't be bothered to write out twice. */
		return validNumber.contains(outwardCodeChar4) || checkLetter(outwardCodeChar4, "CDFGIJKLOQSTUZ") 
			? true : false;
	    }
	}

	/* just to keep the IDE happy, should never reach this */
	return false;
    }


    /**
     * Method to correct the format of a postcode, without regards to the contents.
     * @param postcode the postcode to reformat.
     * @return the postcode, now capitalised, and with a gap before the last three characters.
     */
    public static String correctFormat(String postcode) {

	postcode = postcode.toUpperCase();

	/* get rid of all gaps */
	postcode = postcode.replace(" ", "");

	/* return postcode with gap placed in the correct position*/
	return postcode.substring(0, postcode.length() - 3) + " " + postcode.substring(postcode.length() - 3);
    }

    /** 
     * Private method to check that a String is made up entirely of capitalised letters.
     * @param checkThis String to check.
     * @param excludeTheseLetters letters that are invalid, do not include if every letter is valid.
     * @return true if the String only includes letters and contains no invalid letters, and 
     * false otherwise.
     */
    private static boolean checkLetter(String checkThis, String excludeTheseLetters) {

	/* While checkThis is more than a single character, run each character in turn through
	 * the method and return false if it isn't valid. */
	while (checkThis.length() > 1) {
	    if (checkLetter(checkThis.substring(0, 1), excludeTheseLetters)) {
		checkThis = checkThis.substring(1);
	    } else {
		return false;
	    }
	}

	String validLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	excludeTheseLetters = excludeTheseLetters.toUpperCase();
	checkThis = checkThis.toUpperCase();

	/* remove the invalid letters from validLetters. */
	for (int i = 0; i < excludeTheseLetters.length(); i++) {
	    validLetters.replace(excludeTheseLetters.substring(i, i + 1), "");
	}

	return validLetters.contains(checkThis) ? true : false;
    }

    private static boolean checkLetter(String letter) {
	return checkLetter(letter, "");
    }
}
