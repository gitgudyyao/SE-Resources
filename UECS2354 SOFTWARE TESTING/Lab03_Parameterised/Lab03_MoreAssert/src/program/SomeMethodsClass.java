package program;
public class SomeMethodsClass {
	
	// 	desired method functionality:
	// Given an array of Strings and a single String strToAdd, 
	// strToAdd is appended to every String element in the array
	
	public void addSomeStrings(String[] strArray, String strToAdd) {
		for (int i = 0; i < strArray.length; i++)
			strArray[i] += strToAdd;
	}

	// 	desired method functionality:
	// Given an int parameter age, the method checks to see whether 
	// age falls within a certain numeric range. If it does, the 
	// method returns true; otherwise the method returns false
	
	public boolean checkHumanAge(int age) {
		if (age >0 && age < 130)
			return true;
		else
			return false;
	}
	
	// 	desired method functionality:
	// Given an array of Strings and an int parameter strLength, 
	// the method returns the first String element in the array 
	// whose length is larger than strLength. If there are no
	// elements whose length is larger than strLength, than a null
	// value is returned

	public String getAString(String[] strArray, int strLength) {
		String strToReturn = null;
		for (int i = 0; i < strArray.length; i++)
			if (strArray[i].length() > strLength) {
				strToReturn = strArray[i];
				break;
			}
		return strToReturn;
	}

	// 	desired method functionality:
	// Given an array of Strings and an int parameter pos, 
	// the method returns the String element in the array 
	// at index position pos
	
	public String getStringAtPos(String[] strArray, int pos) {
		return strArray[pos];
	}

}
