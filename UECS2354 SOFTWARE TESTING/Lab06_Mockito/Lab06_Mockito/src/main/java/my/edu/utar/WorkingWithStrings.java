package my.edu.utar;


class SomeOtherWork {
	
	public void doOtherStuff(String message) {
		// lots of other complex code
	}
}


public class WorkingWithStrings {
	
	SomeOtherWork sow = new SomeOtherWork();
	// if the length of any of the string elements in the 
	// strArray is larger than strLimit
	// that string element is passed to the method 
	// doOtherStuff from the class SomeOtherWork
	public void checkStringLength(String[] strArray, int strLimit) {
		for (int i = 0; i < strArray.length; i++)
			if (strArray[i].length() > strLimit)
				sow.doOtherStuff(strArray[i]);
	}

}
