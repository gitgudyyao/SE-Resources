package my.edu.utar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtilities {
	
	public String[] readStringsFromFile(String fileName) {
		
		ArrayList<String> stringsRead = new ArrayList<>();

		File fileToRead = new File(fileName);
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(fileToRead);
		}
		
		catch(FileNotFoundException e)
		{
			throw new IllegalArgumentException("File does not exist : " + fileName);
		}
		
		String lineRead = null;
		while (inputStream.hasNextLine())
		{
			lineRead = inputStream.nextLine();
			stringsRead.add(lineRead);
		}
		inputStream.close();
		
		String[] arrayToReturn = new String[stringsRead.size()];
		arrayToReturn = stringsRead.toArray(arrayToReturn);
		return arrayToReturn;
	}
	
	public void writeStringsToFile(String[] stringsToWrite, String fileName) {
		
		File theFile = new File(fileName);
		PrintWriter output = null;
		try {
			output = new PrintWriter(theFile);
			for (String s : stringsToWrite) {
				output.println(s);
				
			}
		}
		catch(FileNotFoundException e)
		{
			throw new IllegalArgumentException("Problem opening file : " + fileName);
		}
			
		output.close();
	}


}
