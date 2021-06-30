package my.edu.utar;


class Student {
	
	private String name;
	private int age;
	
	public Student (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class OtherMethods {
	
	
	// desired method functionality:
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

	// desired method functionality:
	// Given an integer array, find the largest number  
	// contained in that array
	
	public int findLargestNumberInArray(int[] numArray) {
		
		int bigNum = numArray[0];
		for (int i = 0; i < numArray.length; i++)
			if (bigNum < numArray[i])
				bigNum = numArray[i];
		return bigNum;
	}
	
	// desired method functionality:
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

	// desired method functionality:
	// Given an array of Student objects studArray and an array of Strings, namesToFind
	// calculate the average age of all Students whose names are found 
	// in the array namesToFind. To do this, 
	// iterate through the Student array and check whether the Student 
	// name is found in the array of Strings. If it is, 
	// accumulate the age of that Student in a counter. 
	// Use the accumulated value to calculate the average of these 
	// Student ages.
	
	public double getStudentAverage(Student[] studArray, String[] namesToFind) {

		int countStudent = 0;
		int sumAge = 0;
		
		for (int i = 0; i < studArray.length; i++) {
			for (int j = 0; j < namesToFind.length; j++) {
				if (namesToFind[j].equals(studArray[i].getName())) {
					countStudent++;
					sumAge += studArray[i].getAge();
				}
			}
		}
		if (countStudent == 0) return 0;
		double average = (double) sumAge / countStudent;		
		return average;
	}
	
	
	// desired method functionality:
	// Given an array of Strings and an array of integers 
	// that are of identical length; for each element of the
	// String array x, break the element into smaller substrings.
	// Obtain the substring at the position indicated by the array value 
	// at the same position as the current element. 
	// Concatenate all these substrings into a single string, and 
	// return this string.
	
	// example:
	// strArray[0] = "cat dog mouse"
	// strArray[1] = "house fish"
	// strArray[2] = "rendang satay curry mee laksa"
	// strPos[0] = 2: --> mouse
	// strPos[1] = 0: --> house
	// strPos[2] = 3 --> mee
	//
	// result returned: "mouse house mee"
	
	public String getSubStrings(String[] strArray, int[] strPos) {
		
		String returnStr = "";
		String[] words;
		
		for (int i = 0; i < strArray.length; i++) {
			words = strArray[i].split(" ");
			if (strPos[i] <= words.length) {
				returnStr += words[strPos[i]] + " ";
			}		
		}
		return returnStr.trim();
	}

}
