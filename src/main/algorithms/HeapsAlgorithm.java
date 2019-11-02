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
    private int numberOfPurmutations;
    private int[][] allPermutations;

    //and fields that are used in the calculation process.

    //(I'm not entirely sure what 'n' does, however it is vital to the
    // algorithm, and so I've kept the name 'n', as it was named in the 
    // example where I originally found the formula)
    private int permutationNumber;
    private int[] workingPermutation;
    private int n;
    /**
     * Creates a new instance of HeapsAlgorithm.
     * 
     * @param lengthOfList length of list to find every possible combination of, must be
     * greater than or equal to zero.
     */
    public HeapsAlgorithm(int lengthOfList) {
	if (n < 0) {
	    throw new IllegalArgumentException("lengthOfList must be greater than zero");
	}
	this.lengthOfList = lengthOfList;
	this.numberOfPurmutations = factorial(lengthOfList);
	allPermutations = new int[numberOfPurmutations][lengthOfList];

	//get a list of ascending numbers, of length lengthOfList
	workingPermutation = new int[lengthOfList];
	for (int i = 0; i < lengthOfList; i++) {
	    workingPermutation[i] = i;
	}

	//work out every combination using Heap's Algorithm, 
	//and save each one to a different index of allPermutations.
	permutationNumber = 0;
	n = lengthOfList;
	if (n > 0) {
	    getAllPermutations();
	}
    }

    /**
     * method to retrieve a single int from an instance of HeapsAlgorithm.
     * 
     * @param permutationNumber the permutation of the algorithm.
     * @param indexToRetrieve the index of the specified permutation.
     * @return
     */
    public int get(int permutationNumber, int indexToRetrieve) {
	try {
	    return allPermutations[permutationNumber][indexToRetrieve];
	} catch (ArrayIndexOutOfBoundsException e) {
	    if (permutationNumber > numberOfPurmutations - 1) {
	    	throw new IllegalArgumentException("permutationNumber must be between 0 and " + (numberOfPurmutations - 1) + ".");
	    } else {
		throw new IllegalArgumentException("indexToRetrieve must be between 0 and " + (lengthOfList - 1) + ".");
	    }
	}
    }

    public int getNumberOfPurmutations() {
	return numberOfPurmutations;
    }

    public int getLengthOfList() {
	return lengthOfList;
    }

    private void getAllPermutations() {

	//magic algorithm I don't quite understand... seems to work fine.
	//used variable "returnIndex" to assign location in the array of all results.
	if (n == 1) {
	    for (int i = 0; i < lengthOfList; i++) {
		allPermutations[permutationNumber][i] = workingPermutation[i];
	    }
	    permutationNumber++;
	} else {
	    n--;
	    getAllPermutations();
	    for(int i = 0; i < n - 1; i++) {
		if(n % 2 == 0) {
		    swap(i, n - 1);
		} else {
		    swap(0, n - 1);
		}
		n--;
		getAllPermutations();
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
