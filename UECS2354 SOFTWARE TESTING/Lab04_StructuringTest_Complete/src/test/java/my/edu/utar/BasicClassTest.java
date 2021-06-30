package my.edu.utar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicClassTest {

	BasicClass bc = new BasicClass();
	static ArrayList<String[]> linesRead;
	static Scanner inputStream;

	@BeforeClass
	public static void setupClass() {
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

	@AfterClass
	public static void endClass() {
		// Closing the input file once all tests are complete
		System.out.println("Closing input file");
		inputStream.close();
	}

	@Before
	public void setupMethod() {
		System.out.println("Initializing the list");
		bc.initializeList();
	}

	@Test
	public void testAddStringsToListV1() {
		System.out.println("First version of testAddStringsToList");
		String[] inputStr = linesRead.get(0);
		String[] expectedResult = linesRead.get(1);
		bc.setStrLimit(3);
		bc.addStringsToList(inputStr);
		String[] result = bc.getArrayList();
		assertArrayEquals(expectedResult, result);
	}

	@Test
	public void testAddStringsToListV2() {
		System.out.println("Second version of testAddStringsToList");
		String[] inputStr = linesRead.get(3);
		String[] expectedResult = linesRead.get(4);
		bc.setStrLimit(3);
		bc.addStringsToList(inputStr);
		String[] result = bc.getArrayList();
		assertArrayEquals(expectedResult, result);
	}

	@Test
	public void testGetTotalStringLengthV1() {
		System.out.println("First version of testGetTotalStringLength");
		String[] inputStr = linesRead.get(0);
		String[] tempStr = linesRead.get(2);
		int expectedResult = Integer.parseInt(tempStr[0]);
		bc.setStrLimit(3);
		bc.addStringsToList(inputStr);
		int result = bc.getTotalStringLength();
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGetTotalStringLengthV2() {
		System.out.println("Second version of testGetTotalStringLength");
		String[] inputStr = linesRead.get(3);
		String[] tempStr = linesRead.get(5);
		int expectedResult = Integer.parseInt(tempStr[0]);
		bc.setStrLimit(3);
		bc.addStringsToList(inputStr);
		int result = bc.getTotalStringLength();
		assertEquals(expectedResult, result);
	}

}
