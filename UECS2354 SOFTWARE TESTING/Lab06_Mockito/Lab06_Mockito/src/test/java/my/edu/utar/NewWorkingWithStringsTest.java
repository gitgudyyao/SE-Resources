package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.DummyWork;
import my.edu.utar.NewWorkingWithStrings;
import my.edu.utar.StuffFunctionality;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Matchers.anyString;

@RunWith(JUnitParamsRunner.class)
public class NewWorkingWithStringsTest {
	
	@Test
	public void testCheckStringLength() {
	
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		
		DummyWork dw = new DummyWork();
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(dw);
		nww2.checkStringLength(strArray, 4);
		
		String [] results = dw.getStrList();
		String [] expectedResults = {"houses", "elephant"};
		assertArrayEquals(expectedResults, results);
	}		
	
	private Object[] getParamsForTestCheckStringLengthV2() {

		return new Object[] {
			new Object[] {new String[]{"cat", "houses", "dog", "elephant", "rat"}, 4, new String[]{"houses", "elephant"}},
			new Object[] {new String[]{"11", "Peter", "22"}, 3, new String[] {"Peter"}},
			new Object[] {new String[]{"11", "22"}, 10, new String[] {}}
		};
	}
	
	
	@Test
	@Parameters(method = "getParamsForTestCheckStringLengthV2")	
	public void testCheckStringLengthV2(String[] strArray, int strLimit, String[] expectedResults) {
		
		DummyWork dw = new DummyWork();
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(dw);
		
		nww2.checkStringLength(strArray, strLimit);
		String [] results = dw.getStrList();
		assertArrayEquals(expectedResults, results);
	}		
	
	
	
	// Basic Mockito test to verify that the method 
	// doOtherStuff has being called twice
	@Test
	public void testCheckStringLengthMockitoV1() {
		
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		StuffFunctionality sfMock = mock(StuffFunctionality.class);
				
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(sfMock);
		nww2.checkStringLength(strArray, 4);
		
		verify(sfMock, times(2)).doOtherStuff(anyString());
	}
	
	
	// Another Mockito test to verify that the method 
	// doOtherStuff has being called twice, with the values
	// houses and elephant respectively

	@Test
	public void testCheckStringLengthMockitoV2() {
		
		String [] strArray = {"cat", "houses", "dog", "elephant", "rat"};
		StuffFunctionality sfMock = mock(StuffFunctionality.class);
				
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(sfMock);
		nww2.checkStringLength(strArray, 4);
		
		InOrder inOrder = inOrder(sfMock);
		
		inOrder.verify(sfMock).doOtherStuff("houses");
		inOrder.verify(sfMock).doOtherStuff("elephant");
	}	
	
	
	private Object[] getParamsForMockitoTest() {

		return new Object[] {
			new Object[] {new String[]{"cat", "houses", "dog", "elephant", "rat"}, 4, new String[]{"houses", "elephant"}},
			new Object[] {new String[]{"11", "Peter", "22"}, 3, new String[] {"Peter"}},
			new Object[] {new String[]{"11", "22"}, 10, new String[] {}}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForMockitoTest")	
	public void paramTestCheckStringLengthMockito(String[] strArray, int strLimit, String[] expectedResults) {
		
		
		StuffFunctionality sfMock = mock(StuffFunctionality.class);
		NewWorkingWithStrings nww2 = new NewWorkingWithStrings(sfMock);
		nww2.checkStringLength(strArray, strLimit);
		
		InOrder inOrder = inOrder(sfMock);
		
		for (int i = 0; i < expectedResults.length; i++)
			inOrder.verify(sfMock).doOtherStuff(expectedResults[i]);		
	}
}
