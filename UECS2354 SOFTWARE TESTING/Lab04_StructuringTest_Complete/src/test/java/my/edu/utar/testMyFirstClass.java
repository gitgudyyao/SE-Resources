package my.edu.utar;

import org.junit.Test;
import static org.junit.Assert.*;

public class testMyFirstClass {

	@Test
	public void testAddTwoNumbers() {
		Student s = new Student();
		assertEquals(25, s.addTwoNumbers(10, 15));
	}
}
