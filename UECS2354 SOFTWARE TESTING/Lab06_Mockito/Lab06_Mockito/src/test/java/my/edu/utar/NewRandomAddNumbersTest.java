package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

import my.edu.utar.DummyRandomNumber;
import my.edu.utar.NewRandomAddNumbers;
import my.edu.utar.RandomAddNumbers;
import my.edu.utar.RandomGeneratorClass;
import my.edu.utar.RandomNumberFunctionality;

public class NewRandomAddNumbersTest {
	
	@Test
	public void testAddTwoNumbersDummy() {
		// Setting up the test 
		RandomNumberFunctionality dummy = new DummyRandomNumber(5);
		NewRandomAddNumbers nr1 = new NewRandomAddNumbers(dummy);
		
		// Executing the test
		int result = nr1.addTwoNumbers(3);
		assertEquals(8, result);
	}	

	@Test
	public void testAddTwoNumbersMockito() {
		RandomNumberFunctionality rnMock = mock(RandomNumberFunctionality.class);
		when(rnMock.getRandomInteger(anyInt())).thenReturn(5);	
		
		NewRandomAddNumbers nr1 = new NewRandomAddNumbers(rnMock);
		
		// Executing the test
		int result = nr1.addTwoNumbers(3);
		assertEquals(8, result);
	}
	
	@Test
	public void testAddTwoNumbersWithoutInterface() {
		RandomGeneratorClass rnMock = mock(RandomGeneratorClass.class);
		when(rnMock.getRandomInteger(anyInt())).thenReturn(5);	
		
		RandomAddNumbers nr1 = new RandomAddNumbers(rnMock);
		
		// Executing the test
		int result = nr1.addTwoNumbers(3);
		assertEquals(8, result);
	}
}
