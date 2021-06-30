package my.edu.utar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleClassTestV1 {

	@Test
	public void testGetSumNumbers() {
		SimpleClass sc = new SimpleClass(5, 3);
		sc.initializeArray();
		// add 3, 4, 5, 6, 7
		int result = sc.getSumNumbers();
		assertEquals(25, result);
	}

	@Test
	public void testFindLargestNumber() {
		SimpleClass sc = new SimpleClass(5, 3);
		sc.initializeArray();
		// find largest number in 3, 4, 5, 6, 7
		int result = sc.findLargestNumber();
		assertEquals(7, result);
	}

	@Test
	public void testFindSmallestNumber() {
		SimpleClass sc = new SimpleClass(5, 3);
		sc.initializeArray();
		// find largest number in 3, 4, 5, 6, 7
		int result = sc.findSmallestNumber();
		assertEquals(3, result);
	}
}
