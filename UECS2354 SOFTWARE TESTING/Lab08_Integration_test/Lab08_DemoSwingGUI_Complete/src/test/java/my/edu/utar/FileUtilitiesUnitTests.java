package my.edu.utar;

import org.junit.Test;

import my.edu.utar.FileUtilities;

import static org.junit.Assert.*;

public class FileUtilitiesUnitTests {
	
	@Test
	public void testReadAndWrite() {
		
		FileUtilities fu = new FileUtilities();
		String[] testStrings = new String[] {"cat", "dog mouse elephant", "","rat monkey","  "};
		
		fu.writeStringsToFile(testStrings, "dummyfile1.txt");
		
		String[] stringsFromFile = fu.readStringsFromFile("dummyfile1.txt");
		
		assertArrayEquals(stringsFromFile, testStrings);
	}

	@Test(expected=IllegalArgumentException.class)	
	public void testReadWithError() {
		FileUtilities fu = new FileUtilities();
		fu.readStringsFromFile("somecrazyfilenamethatdoesnotexist");
	}
	

}
