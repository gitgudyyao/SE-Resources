package my.edu.utar;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextFileInputDemo {

	public static void main(String[] args) {

		ArrayList<String[]> linesRead = new ArrayList<String[]>();
		String fileName = "values.txt";
		Scanner inputStream = null;
		System.out.println("The file " + fileName + "\ncontains the following lines:\n");

		try {
			inputStream = new Scanner(new File(fileName));
		}

		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

		while (inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(" ");
			linesRead.add(tokens);
		}

		int lineNum = 1;
		for (String[] strArray : linesRead) {
			System.out.print("Line " + lineNum + " : ");
			for (int i = 0; i < strArray.length; i++)
				System.out.print(strArray[i] + " ");
			lineNum++;
			System.out.println();
		}

		inputStream.close();
	}
}