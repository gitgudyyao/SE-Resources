package my.edu.utar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class SimpleClassTestV3 {

	SimpleClass sc = new SimpleClass(5, 3);

	@Before
	public void setup() {
		sc.initializeArray();
	}

	@Test
	public void testGetSumNumbers() {
		// add 3, 4, 5, 6, 7
		int result = sc.getSumNumbers();
		assertEquals(25, result);
	}

	@Test
	public void testFindLargestNumber() {
		// find largest number in 3, 4, 5, 6, 7
		int result = sc.findLargestNumber();
		assertEquals(7, result);
	}

	@Test
	public void testFindSmallestNumber() {
		// find largest number in 3, 4, 5, 6, 7
		int result = sc.findSmallestNumber();
		assertEquals(3, result);
	}
}
