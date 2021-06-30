
package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

import my.edu.utar.ArrayGeneratorClass;
import my.edu.utar.NewRandomFindLargest;
import my.edu.utar.RandomFindLargest;
import my.edu.utar.RandomGeneratorClass;
import my.edu.utar.RandomNumberFunctionality;


public class NewRandomFindLargestTest {
	
	@Test
	public void testFindLargestNumberInRandomArrayDummy() {
		
		// setup code
		ArrayGeneratorClass dgc = new ArrayGeneratorClass(new int[] {1,2,3,4,5,6,7,8});
		NewRandomFindLargest nr2 = new NewRandomFindLargest(dgc);
		
		//create an array of length 5, and fill it with predetermined
		// numbers from 1 to 8
		int result = nr2.findLargestNumberInRandomArray(5, 8);
		assertEquals(5, result);
	}	
	
	@Test
	public void testFindLargestNumberInRandomArrayMockito() {

		// setup code
		RandomNumberFunctionality rnMock = mock(RandomNumberFunctionality.class);
		when(rnMock.getRandomInteger(anyInt())).thenReturn(11, 20, 6, 15, 19);	
		
		NewRandomFindLargest nr2 = new NewRandomFindLargest(rnMock);
		
		//create an array of length 5, and fill it with predetermined
		// numbers from 1 to 8
		int result = nr2.findLargestNumberInRandomArray(5, 8);
		assertEquals(20, result);
	}
	
	@Test
	public void testFindLargestNumberInRandomArrayMockitoWithoutInterface() {

		// setup code
		RandomGeneratorClass rnMock = mock(RandomGeneratorClass.class);
		when(rnMock.getRandomInteger(anyInt())).thenReturn(11, 20, 6, 15, 19);	
		
		RandomFindLargest nr2 = new RandomFindLargest(rnMock);
		
		//create an array of length 5, and fill it with predetermined
		// numbers from 1 to 8
		int result = nr2.findLargestNumberInRandomArray(5, 8);
		assertEquals(20, result);
	}
	
	
}
