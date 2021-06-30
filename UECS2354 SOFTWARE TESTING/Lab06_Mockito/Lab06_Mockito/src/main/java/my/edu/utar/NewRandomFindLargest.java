package my.edu.utar;


class ArrayGeneratorClass implements RandomNumberFunctionality {
	
	int numCalls = 0;
	int[] fixedNumbers;
	
	public ArrayGeneratorClass(int[] fixedNumbers) {
		this.fixedNumbers = fixedNumbers;
	}
	
	public void resetCount() {
		numCalls = 0;
	}

	public int getRandomInteger(int numLimit) {
	    int numToReturn = fixedNumbers[numCalls];
	    numCalls++;
		return numToReturn;
	}
}


public class NewRandomFindLargest {
	
	RandomNumberFunctionality rnf;	
	
	public NewRandomFindLargest() {
		rnf = new NewRandomGeneratorClass();
	}
	
	public NewRandomFindLargest(RandomNumberFunctionality rnf) {
		this.rnf = rnf;
	}
	
	public int findLargestNumberInRandomArray(int arrLength, int numLimit) {
		
		// first create an integer array of the desired size
		// then populate array with random integers
		
		int[] numArray = new int[arrLength];
		System.out.println();
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = rnf.getRandomInteger(numLimit);
			System.out.println ("numArray["+ i +"] = " + numArray[i]);
		}
		
		// then go through this array to find the largest number
		
		int bigNum = numArray[0];
		for (int i = 0; i < numArray.length; i++)
			if (bigNum < numArray[i])
				bigNum = numArray[i];
		return bigNum;
	}
	
	public static void main(String args[]) {
		
		NewRandomFindLargest nr = new NewRandomFindLargest();
		
		//Using the original random Number generator functionality
		// Generate numbers between 0 and 5 in an array of size 8
		
		System.out.println("Working with random functionality");
		nr.findLargestNumberInRandomArray(8, 5);

		//Using the dummy generator class which will return 
		// an array of fixed size (8) containing fixed integers
		// No matter what parameters we pass to 
		// findLargestNumberInRandomArray, the output is always the same

		System.out.println("Working with dummy functionality");
		ArrayGeneratorClass dgc = new ArrayGeneratorClass(new int[] {1,2,3,4,5,6,7,8});
		NewRandomFindLargest nr2 = new NewRandomFindLargest(dgc);
		
		System.out.println("Calling findLargestNumberInRandomArray with parameters 8 and 5");
		nr2.findLargestNumberInRandomArray(8, 5);
		
		System.out.println("Calling findLargestNumberInRandomArray with parameters 4 and 15");
		dgc.resetCount();
		nr2.findLargestNumberInRandomArray(4, 15);

		System.out.println("Calling findLargestNumberInRandomArray with parameters 6 and 10");
		dgc.resetCount();
		nr2.findLargestNumberInRandomArray(6, 10);
	}

}
