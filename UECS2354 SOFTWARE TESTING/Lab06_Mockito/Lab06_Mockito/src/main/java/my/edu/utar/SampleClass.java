package my.edu.utar;

class FileReaderClass {
	
	public int getNumberFromFile() {
		// code to open a file and read a number
		// from it and return this number
		
		System.out.println ("The real getNumberFromFile called");
		
		int numberToReturn = 10;
		return numberToReturn;
	}
}

class FileWriterClass {
	
	public void writeDataToFile(int dataToWrite) {
		
		System.out.println ("The real writeDataToFile called");
		
		// code to open a file and write the parameter
		// dataToWrite 
	}
}

public class SampleClass {
	
	FileReaderClass frc;
	FileWriterClass fwc;
	
	public SampleClass() {
		frc = new FileReaderClass();
		fwc = new FileWriterClass();
	}
	
	public SampleClass(FileReaderClass frc, FileWriterClass fwc) {
		this.frc = frc;
		this.fwc = fwc;
	}
	
	public void sampleMethod() {
				
		// Create an integer array and 
		// fill it with numbers read from file
		
		int[] numsFromFile = new int[5];
		for (int i = 0; i < 5; i++)
			numsFromFile[i] = frc.getNumberFromFile();
		
		// Do some processing on numsFromFile
		
		// Write the new values in numsFromFile to the file
		
		for (int i = 0; i < 5; i++)
			fwc.writeDataToFile(numsFromFile[i]);
	}
}
