package program;
import java.util.StringTokenizer;

public class VariousMethodsClass {

	// accept two integers numbers as parameters and return the sum of them
	
	public int addTwoNumbers(int a, int b) {
		return a + b;
	}
	
	// Given a String words containing a sequence of smaller strings, 
	// count the number of occurrences of the String strFind in words
	
	public int countWordInString(String words, String strFind) {
		
		int posStrToFind = words.indexOf(strFind);
		int wordCount = 0;
		while (posStrToFind != -1) {
			wordCount++;
			posStrToFind = words.indexOf(strFind, posStrToFind+1);
		}
		return wordCount;
	}	

	// Given a String words containing a sequence of smaller strings and 
	// an integer x, return a String which contains the smaller strings 
	// from words whose length is greater than x.
	
	public String combineStrings(String words, int x) {
		
		StringTokenizer st = new StringTokenizer(words);
		String returnStr = "";
		
		while (st.hasMoreElements()) {
			String currentWord = (String) st.nextElement();
			if (currentWord.length() > x)
				returnStr = returnStr + currentWord + " ";
		}
		return returnStr.trim();
	}
	
	// Given an integer array, find the largest number  
	// contained in that array
	
	public int findLargestNumber(int[] numArray) {
		
		int bigNum = numArray[0];
		for (int i = 0; i < numArray.length; i++)
			if (bigNum < numArray[i])
				bigNum = numArray[i];
		return bigNum;
	}
	
	// Given an array of Strings and an integer x, calculate the 
	// average of the length of the String elements in the array 
	// whose length is greater than x.
			
	public double averageStringLength(String[] strArray, int x) {
		
		int countWords = 0;
		int sumLength = 0;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].length() > x) {
				sumLength += strArray[i].length();
				countWords++;
			}
		}
		if (countWords == 0) return 0;
		double average = (double) sumLength / countWords;		
		return average;
	}
}
