package my.edu.utar;

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

