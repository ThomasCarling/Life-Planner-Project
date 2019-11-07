package algorithms;

/**
 * Class to calculate every possible combination of a list of 
 * individual ascending numbers, starting at zero.
 * 
 * @author Thomas
 *
 */
public class HeapsAlgorithm {

    //fields that are the end result.
    private int lengthOfList;
    private int numberOfPermutations;
    private int[][] allPermutations;

    //and fields that are used in the calculation process.
    private int permutationNumber;
    private int[] workingPermutation;
    /**
     * Creates a new instance of HeapsAlgorithm.
     * 
     * @param lengthOfList Length of list to find every possible combination of, must be
     * greater than or equal to zero.
     */
    public HeapsAlgorithm(int lengthOfList) {
	if (lengthOfList < 0) {
	    throw new IllegalArgumentException("lengthOfList must be greater than zero");
	}
	this.lengthOfList = lengthOfList;
	this.numberOfPermutations = factorial(lengthOfList);
	allPermutations = new int[numberOfPermutations][lengthOfList];

	//get a list of ascending numbers, of length lengthOfList
	workingPermutation = new int[lengthOfList];
	for (int i = 0; i < lengthOfList; i++) {
	    workingPermutation[i] = i;
	}

	//work out every combination using Heap's Algorithm, 
	//and save each one to a different index of allPermutations.
	permutationNumber = 0;
	if (lengthOfList > 0) {
	    getAllPermutations(lengthOfList);
	}
    }

    /**
     * <ethod to retrieve a single int from an instance of HeapsAlgorithm.
     * 
     * @param permutationNumber The permutation of the algorithm.
     * @param indexToRetrieve The index of the specified permutation.
     * @return The specified int.
     */
    public int get(int permutationNumber, int indexToRetrieve) {
	try {
	    return allPermutations[permutationNumber][indexToRetrieve];
	} catch (ArrayIndexOutOfBoundsException e) {
	    if (permutationNumber > numberOfPermutations - 1) {
	    	throw new IllegalArgumentException("permutationNumber must be between 0 and " + (numberOfPermutations - 1) + ".");
	    } else {
		throw new IllegalArgumentException("indexToRetrieve must be between 0 and " + (lengthOfList - 1) + ".");
	    }
	}
    }
    
    /**
     * Method to retrieve an array containing the specified permutation of the HeapsAlgorithm.
     * @param permutationNumber The permutation to retrieve.
     * @return The specified permutation.
     */
    public int[] getRow(int permutationNumber) {
	int[] row = new int[lengthOfList];
	for (int i = 0; i < lengthOfList; i++) {
	    row[i] = get(permutationNumber, i);
	}
	return row;
    }

    /**
     * Method to return the number of possible permutations.
     * @return The number of possible permutations.
     */
    public int getNumberOfPermutations() {
	return numberOfPermutations;
    }

    /**
     * Method to get the length of each permutation.
     * @return The length.
     */
    public int getLengthOfList() {
	return lengthOfList;
    }

    /**
     * Private method to calculate each individual permutation, based on the length of the list.
     * 
     * @param n Magic number that I don't quite understand, but is vital to the formula. Always
     * starts as the length of the list.
     */
    private void getAllPermutations(int n) {

	//magic algorithm I don't quite understand... seems to work fine.
	//used variable "returnIndex" to assign location in the array of all results.
	if (n == 1) {
	    for (int i = 0; i < lengthOfList; i++) {
		allPermutations[permutationNumber][i] = workingPermutation[i];
	    }
	    permutationNumber++;
	} else {
	    getAllPermutations(n - 1);
	    for(int i = 0; i < n - 1; i++) {
		if(n % 2 == 0) {
		    swap(i, n - 1);
		} else {
		    swap(0, n - 1);
		}
		getAllPermutations(n - 1);
	    }
	}
    }

    //helper methods


    //returns factorial of a number n
    private static int factorial(int n) {
	if (n == 0) {
	    return 1;
	} else {
	    return (n * factorial(n - 1));
	}
    }

    //swaps the ints at the given indices

    private void swap(int firstIndex, int secondIndex) {
	int temp = workingPermutation[firstIndex];
	workingPermutation[firstIndex] = workingPermutation[secondIndex];
	workingPermutation[secondIndex] = temp;
    }
}
