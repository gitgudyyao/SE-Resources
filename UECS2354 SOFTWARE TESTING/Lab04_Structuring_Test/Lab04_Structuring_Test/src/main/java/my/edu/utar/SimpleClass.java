package my.edu.utar;

public class SimpleClass {

	private int[] numArray;
	int someValue;

	public SimpleClass(int arrSize, int someValue) {
		numArray = new int[arrSize];
		this.someValue = someValue;
	}

	public void initializeArray() {
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = someValue + i;
		}
	}

	// returns the sum of the numbers in numArray
	public int getSumNumbers() {
		int total = 0;
		for (int i = 0; i < numArray.length; i++)
			total += numArray[i];
		return total;
	}

	// returns the largest number in numArray
	public int findLargestNumber() {
		int bigNum = numArray[0];
		for (int i = 0; i < numArray.length; i++)
			if (bigNum < numArray[i])
				bigNum = numArray[i];
		return bigNum;
	}

	// returns the smallest number in numArray
	public int findSmallestNumber() {
		int smallNum = numArray[0];
		for (int i = 0; i < numArray.length; i++)
			if (smallNum > numArray[i])
				smallNum = numArray[i];
		return smallNum;
	}

}
