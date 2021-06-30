package my.edu.utar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BasicClassTestV2 {

	BasicClass bc;
	static ArrayList<String[]> linesRead;

	static {
		Scanner inputStream;
		linesRead = new ArrayList<String[]>();
		String fileName = "testvalues.txt";
		inputStream = null;
		System.out.println("Reading test values from file " + fileName + "\n");
		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(" ");
			linesRead.add(tokens);
		}
	}

	public BasicClassTestV2() {
		System.out.println("In constructor");
		bc = new BasicClass();
		bc.initializeList();
		bc.setStrLimit(3);
	}

	private Object[] getDataForTestAddStringsToList() {
		return new Object[] { new Object[] { linesRead.get(0), linesRead.get(1) },
				new Object[] { linesRead.get(3), linesRead.get(4) }, };
	}

	private Object[] getDataForTestGetTotalStringLength() {
		return new Object[] { new Object[] { linesRead.get(0), linesRead.get(2) },
				new Object[] { linesRead.get(3), linesRead.get(5) }, };
	}

	@Test
	@Parameters(method = "getDataForTestAddStringsToList")
	public void testAddStringsToList(String[] inputArray, String[] expectedResult) {
		bc.addStringsToList(inputArray);
		String[] result = bc.getArrayList();
		assertArrayEquals(expectedResult, result);
	}

	@Test
	@Parameters(method = "getDataForTestGetTotalStringLength")
	public void testGetTotalStringLength(String[] inputArray, String[] tempValue) {
		bc.addStringsToList(inputArray);
		int expectedResult = Integer.parseInt(tempValue[0]);
		int result = bc.getTotalStringLength();
		assertEquals(expectedResult, result);
	}
}
