package my.edu.utar;

import java.util.ArrayList;

public class BasicClass {

	private ArrayList<String> strList;
	private int strLimit = 0;

	public void initializeList() {
		strList = new ArrayList<String>();
	}

	public void setStrLimit(int strLimit) {
		this.strLimit = strLimit;
	}

	// Return strList as an array of Strings
	public String[] getArrayList() {
		String[] returnStr = new String[strList.size()];
		returnStr = strList.toArray(returnStr);
		return returnStr;
	}

	// Takes an array strToAdd, and for every element in this
	// array whose length is more than strLimit, add that
	// element to strList.

	public void addStringsToList(String[] strToAdd) {
		for (int i = 0; i < strToAdd.length; i++) {
			if (strToAdd[i].length() > strLimit)
				strList.add(strToAdd[i]);
		}
	}

	// returns the total length of all the strings
	// contained in strList

	public int getTotalStringLength() {
		int totalCount = 0;
		for (String str : strList)
			totalCount += str.length();
		return totalCount;
	}
}
