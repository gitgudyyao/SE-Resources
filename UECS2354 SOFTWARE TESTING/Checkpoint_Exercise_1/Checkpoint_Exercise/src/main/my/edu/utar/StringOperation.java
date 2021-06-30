package my.edu.utar;

import java.util.ArrayList;

public class StringOperation {
	
	public String[] compareStringArrays(int numToCompare, String[] strArray1, String[] strArray2) {
		
		ArrayList<String> resultList = new ArrayList<>();
		for (int i = 0; i < numToCompare; i++) {
			for (int j = 0; j < numToCompare; j++) {
				if (strArray1[i].equals(strArray2[j])) {
					resultList.add(strArray1[i]);
				}
			}
		}
		String[] arrayToReturn = new String[resultList.size()];
		arrayToReturn = resultList.toArray(arrayToReturn);
		return arrayToReturn;
	}
}
