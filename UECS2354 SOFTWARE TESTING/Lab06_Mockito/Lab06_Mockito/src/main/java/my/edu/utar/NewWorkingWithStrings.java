package my.edu.utar;

import java.util.ArrayList;

interface StuffFunctionality {
	public void doOtherStuff(String message);  
}

class NewSomeOtherWork implements StuffFunctionality {
	
	public void doOtherStuff(String message) {
		// lots of other complex code
	}
}

class DummyWork implements StuffFunctionality {
	
	ArrayList<String> strList = new ArrayList<String>();

	public void doOtherStuff(String message) {
		strList.add(message);
	}
	
	// convert the ArrayList of strings to an
	// array of STrings. Then return this array
	public String[] getStrList() {
		String[] strArrayToReturn = new String[strList.size()];
		strArrayToReturn = strList.toArray(strArrayToReturn);
		return strArrayToReturn;
	}
}

public class NewWorkingWithStrings {
	
	StuffFunctionality sf;
	
	public NewWorkingWithStrings() {
		sf = new NewSomeOtherWork();
	}
	
	public NewWorkingWithStrings(StuffFunctionality sf) {
		this.sf = sf;
	}
	
	// if the length of any of the string elements in the 
	// strArray is larger than strLimit
	// that string element is passed to the method 
	// doOtherStuff from the class SomeOtherWork
	public void checkStringLength(String[] strArray, int strLimit) {
		for (int i = 0; i < strArray.length; i++)
			if (strArray[i].length() > strLimit)
				sf.doOtherStuff(strArray[i]);
	}	
	
	public static void main(String[] args) {
		
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		
		// With this approach we have no way of knowing
		// whether the method worked
		NewWorkingWithStrings nww1 = new NewWorkingWithStrings();
		nww1.checkStringLength(strArray, 4);
		
		// With this approach, we can get the array of strings
		// back from DummyWork to see whether it contains all 
		// the strings  whose length are more than 4
		DummyWork dw = new DummyWork();
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(dw);
		//return all the strings with length more than 4
		nww2.checkStringLength(strArray, 4);
		
		String [] results = dw.getStrList();
		System.out.println("Results are : ");
		for (int i = 0; i < results.length; i++)
			System.out.println(results[i]);
		
	}

}
