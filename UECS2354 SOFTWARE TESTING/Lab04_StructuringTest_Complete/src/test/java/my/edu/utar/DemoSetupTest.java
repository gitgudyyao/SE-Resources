package my.edu.utar;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class DemoSetupTest {

	static int x = 0;
	int y = 0;

	@BeforeClass
	public static void setupClass() {
		x = 5;
		System.out.println("setup class");
	}

	@AfterClass
	public static void endClass() {
		System.out.println("end class");
	}

	@Before
	public void setupMethod() {
		y += 10;
		System.out.println("setup method. x = " + x + " y = " + y);
	}

	@After
	public void endMethod() {
		y += 20;
		System.out.println("end method. x = " + x + " y = " + y);
	}

	@Test
	public void thirdTest() {
		System.out.println("third Test. x = " + x + " y = " + y);
		x += 1;

	}

	@Test
	public void secondTest() {
		System.out.println("second Test. x = " + x + " y = " + y);
		x += 1;
	}

	@Test
	public void firstTest() {
		System.out.println("first Test. x = " + x + " y = " + y);
		x += 1;
	}
}
