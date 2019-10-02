package algorithms;

public class HeapsAlgorithm {
    
    //Algorithm to find every possible order of ints in an array
    
    public static int returnIndex;
    
    public static int[][] calculate(int[] list) {
	
	//length of list
	int length = list.length;
	if (length == 0) {
	    return null;
	}
	//number of possible combinations
	int totalCombinations = factorial(length);
	
	//array to save each combination
	int[][] result = new int[totalCombinations][length];
	
	//index to save permutation to
	returnIndex = 0;
	

	calculate(list, length, result, length);
	return result;
	
    }
    
    // gist of the algorithm
    
    private static void calculate(int[] list, int n, int[][] result, int length) {
	
	//magic algorithm I don't quite understand...
	//added and then used variable "returnIndex" to assign location in the array of all results.
	if (n == 1) {
	    for (int i = 0; i < length; i++) {
		result[returnIndex][i] = list[i];
	    }
	    returnIndex++;
	} else {
	    calculate(list, n - 1, result, length);
	    for(int i = 0; i < n - 1; i++) {
		if(n % 2 == 0) {
		    swap(list, i, n - 1);
		} else {
		    swap(list, 0, n - 1);
		}
		calculate(list, n - 1, result, length);
	    }
	}
    }
        
    //helper methods
    
    
    //returns factorial of a number n
    
    protected static int factorial(int n) {
	if (n == 0) {
	    return 1;
	} else {
	    return (n * factorial(n - 1));
	}
    }
    
    //swaps the ints at the given indices
    
    protected static void swap(int[] list, int firstIndex, int secondIndex) {
	int temp = list[firstIndex];
	list[firstIndex] = list[secondIndex];
	list[secondIndex] = temp;
    }
}
