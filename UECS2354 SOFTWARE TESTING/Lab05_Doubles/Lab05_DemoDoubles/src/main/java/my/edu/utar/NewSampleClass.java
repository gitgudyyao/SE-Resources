package my.edu.utar;

import java.util.ArrayList;

interface ReadFunctionality {
	public int getNumberFromFile(); 
}

interface WriteFunctionality {
	public void writeDataToFile(int dataToWrite); 
}

class NewFileReaderClass implements ReadFunctionality {
	
	public int getNumberFromFile() {
		// code to open a file and read a number
		// from it and return this number
		
		int numberToReturn = 10;
		return numberToReturn;
	}
}

class NewFileWriterClass implements WriteFunctionality {
	
	public void writeDataToFile(int dataToWrite) {
		// code to open a file and write the parameter
		// dataToWrite 
	}	
}

class DummyReaderClass implements ReadFunctionality {
	
	int numCalls = 0;
	int[] fixedNumbers;
	
	public DummyReaderClass(int[] fixedNumbers) {
		this.fixedNumbers = fixedNumbers;
	}
	
	public void resetCount() {
		numCalls = 0;
	}

	public int getNumberFromFile() {
	    int numToReturn = fixedNumbers[numCalls];
	    numCalls++;
		return numToReturn;
	}	
}

class DummyWriterClass implements WriteFunctionality {
	
	ArrayList<Integer> intList = new ArrayList<Integer>();
	
	public void writeDataToFile(int dataToWrite) {
		intList.add(dataToWrite);
	}

	// convert the ArrayList of integers to an
	// array of ints. Then return this array
	public int[] getIntList() {
		int[] intArrayToReturn = new int[intList.size()];
		int i = 0;
		for (Integer x : intList) {
			intArrayToReturn[i++] = x;
		}
		return intArrayToReturn;
	}	
}

public class NewSampleClass {
	
	ReadFunctionality rf;
	WriteFunctionality wf;
	
	public NewSampleClass(ReadFunctionality rf, WriteFunctionality wf) {
		this.rf = rf;
		this.wf = wf;
	}
	
	public void sampleMethod() {
		
		// Create an integer array and 
		// fill it with numbers read from file
		
		int[] numsFromFile = new int[5];
		for (int i = 0; i < 5; i++)
			numsFromFile[i] = rf.getNumberFromFile();
		
		// Do some processing on numsFromFile
		
		// Write the new values in numsFromFile to the file
		
		for (int i = 0; i < 5; i++)
			wf.writeDataToFile(numsFromFile[i]);
	}
}
