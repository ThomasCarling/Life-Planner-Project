package oldmain.addresses;

public class PostcodeChecker {

    public static boolean check(String postcode) {

	postcode = postcode.toUpperCase();

	String finalFirst;
	String finalSecond;

	String firstHalf = getSubstring(postcode, true).trim();
	String secondHalf = getSubstring(postcode, false).trim();

	if (!(checkLength(firstHalf, true) && !checkLength(secondHalf, false))) {
	    if (canFix(firstHalf, secondHalf)) {

		finalFirst = fix(firstHalf, secondHalf, true);
		finalSecond = fix(firstHalf, secondHalf, false);
		if (checkSecondHalf(finalSecond) && checkFirstHalf(finalFirst)) {
		    return true;
		}
	    }
	}
	return false;
    }

    public static String fix(String postcode) {

	postcode = postcode.toUpperCase();

	String firstHalf = getSubstring(postcode, true).trim();
	String secondHalf = getSubstring(postcode, false).trim();

	String finalFirst = fix(firstHalf, secondHalf, true);
	String finalSecond = fix(firstHalf, secondHalf, false);

	return finalFirst + " " + finalSecond;

    }

    protected static String getSubstring (String toSplit, boolean firstHalf) {

	toSplit = toSplit.trim();

	int whiteSpace = toSplit.indexOf(" ");

	if (firstHalf) {
	    if (whiteSpace == -1) {
		return toSplit;
	    } else {
		return toSplit.substring(0, whiteSpace);
	    }
	} else {
	    if (whiteSpace == -1) {
		return "";
	    } else {
		return toSplit.substring(whiteSpace + 1);
	    }
	}
    }

    protected static boolean checkLength(String half, boolean firstHalf) {
	if (firstHalf) {
	    if (half.length() < 5 && half.length() > 1) {
		return true;
	    }
	    return false;
	} else {
	    if (half.length() == 3) {
		return true;
	    }
	    return false;
	}
    }

    protected static boolean numberCheck(String number) {

	String valid = "1234567890";
	return(valid.contains(number) ? true : false);
    }


    protected static boolean letterCheck(String letter, String exclude) {

	exclude = exclude.toUpperCase();
	letter = letter.toUpperCase();
	String valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	for (int i = 0; i < exclude.length(); i++) {
	    int removeIndex = valid.indexOf(exclude.substring(i, i + 1));
	    valid = valid.substring(0, removeIndex) + valid.substring(removeIndex + 1);
	}

	return valid.contains(letter) ? true : false;
    }

    protected static boolean letterCheck(String letter) {
	return letterCheck(letter, "");
    }

    protected static boolean canFix(String firstHalf, String secondHalf) {

	String whole = firstHalf + secondHalf;
	whole = whole.replaceAll(" ", "");

	return (whole.length() < 8 && whole.length() > 4 ? true : false);
    }

    protected static String fix(String firstHalf, String secondHalf, boolean getFirst) {

	String whole = firstHalf + secondHalf;
	whole = whole.replaceAll(" ", "");

	if (getFirst) {
	    return whole.substring(0, whole.length() - 3);
	} else {
	    return whole.substring(whole.length() - 3);
	}
    }

    protected static boolean checkSecondHalf(String secondHalf) {
	String invalid = "CIKMOV";
	if (numberCheck(secondHalf.substring(0,1))) {
	    if (letterCheck(secondHalf.substring(1,2), invalid)) {
		if (letterCheck(secondHalf.substring(2), invalid)) {
		    return true;
		}
	    }
	}
	return false;
    }

    protected static boolean checkFirstHalf(String firstHalf) {
	if (!letterCheck(firstHalf.substring(0, 1), "QVX")) {
	    return false;
	}

	if (firstHalf.length() == 2) {
	    if (numberCheck(firstHalf.substring(1))) {
		return true;
	    }
	}

	if (firstHalf.length() == 3) {
	    if (numberCheck(firstHalf.substring(1, 2))) {
		if (numberCheck(firstHalf.substring(2))) {
		    return true;
		}
		if (letterCheck(firstHalf.substring(2), "ILMNOPQRVXYZ")) {
		    return true;
		}
	    }
	    if (letterCheck(firstHalf.substring(1, 2), "IJZ")) {
		if (numberCheck(firstHalf.substring(2))) {
		    return true;
		}	    
	    }
	}

	if (firstHalf.length() == 4) {
	    if (letterCheck(firstHalf.substring(1, 2), "IJZ")) {
		if (numberCheck(firstHalf.substring(2, 3))) {
		    if (letterCheck(firstHalf.substring(3))) {
			return true;
		    }
		    if (numberCheck(firstHalf.substring(3))) {
			return true;
		    }
		}
	    }
	}
	return false;
    }
}
