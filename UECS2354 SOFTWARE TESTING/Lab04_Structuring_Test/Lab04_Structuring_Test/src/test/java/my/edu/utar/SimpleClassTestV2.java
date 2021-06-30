package my.edu.utar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleClassTestV2 {

	SimpleClass sc = new SimpleClass(5, 3);

	@Test
	public void testGetSumNumbers() {
		sc.initializeArray();
		// add 3, 4, 5, 6, 7
		int result = sc.getSumNumbers();
		assertEquals(25, result);
	}

	@Test
	public void testFindLargestNumber() {
		sc.initializeArray();
		// find largest number in 3, 4, 5, 6, 7
		int result = sc.findLargestNumber();
		assertEquals(7, result);
	}

	@Test
	public void testFindSmallestNumber() {
		sc.initializeArray();
		// find largest number in 3, 4, 5, 6, 7
		int result = sc.findSmallestNumber();
		assertEquals(3, result);
	}
}
