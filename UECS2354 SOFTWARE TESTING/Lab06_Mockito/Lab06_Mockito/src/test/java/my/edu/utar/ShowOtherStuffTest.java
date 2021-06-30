package my.edu.utar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

import my.edu.utar.MoreStuff;
import my.edu.utar.ReturnStuff;
import my.edu.utar.ShowOtherStuff;
import my.edu.utar.Student;

public class ShowOtherStuffTest {
	
	@Test
	public void testSomeMethod() {
		
		System.out.println ("\nDoing testSomeMethod");
		// Setting up the mock for the first test
		// this will make firstMethod throw an Exception when called
		MoreStuff msMock = mock(MoreStuff.class);
		Student stud = new Student("Peter");
		int [] intArray = {1, 3, 5, 7};
		
		// whenever getIntArray is called, it will return 1, 3, 5, 7
		when(msMock.getIntArray()).thenReturn(intArray);
		
		// when getStudent is called the first time a new Student object with name Peter is returned
		// when getStudent is called the second time a new Student object with name Paul is returned
		when(msMock.getStudent()).thenReturn(stud).thenReturn(new Student("Paul"));
		
		// when firstMethod is called the first time, an exception is thrown,
		// when firstMethod is called the second time, a value of 5 is returned
		when(msMock.firstMethod()).thenThrow(new RuntimeException()).thenReturn(5);

		ShowOtherStuff sos = new ShowOtherStuff();
		sos.setMoreStuff(msMock);		
		
		int result = sos.someMethod();
		assertEquals(5, result);
		
		result = sos.someMethod();
		assertEquals(15, result);
	}
	
	
	// Test to demonstrate verifying exact number of invocations
	@Test
	public void testNumTimesCalled() {
		
		MoreStuff msMock = mock(MoreStuff.class);
		ReturnStuff rsMock = mock(ReturnStuff.class);
		ShowOtherStuff sos = new ShowOtherStuff();
		sos.setMoreStuff(msMock);
		sos.setReturnStuff(rsMock);
		
		sos.anotherMethod();

		verify(msMock, atLeastOnce()).secondMethod("Great");
		verify(msMock, atLeast(3)).secondMethod("cat");
		verify(msMock, atMost(2)).secondMethod("dog");
		verify(msMock, never()).secondMethod("bird");
		verify(msMock, never()).thirdMethod(anyString());

		verifyZeroInteractions(rsMock);
	}
	
	@Test
	public void testDemoArgumentMatchers() {
		
		System.out.println ("\nDoing testDemoArgumentMatchers");
		
		ReturnStuff rsMock = mock(ReturnStuff.class);
		ShowOtherStuff sos = new ShowOtherStuff();
		sos.setReturnStuff(rsMock);

		when(rsMock.methodWithArgs(anyInt(), anyString(), anyString())).thenReturn("something else");	
		when(rsMock.methodWithArgs(anyInt(), eq("great"), anyString())).thenReturn("a");	
		when(rsMock.methodWithArgs(eq(5), startsWith("cat"), anyString())).thenReturn("b");	
		when(rsMock.methodWithArgs(anyInt(), contains("love"), endsWith("dog"))).thenReturn("c");	

		sos.demoArgumentMatchers(400, "great", "wonderful");
		sos.demoArgumentMatchers(5, "catnap", "sleep");
		sos.demoArgumentMatchers(-3, "loveboat", "bigdog");
		sos.demoArgumentMatchers(5, "catlove", "bigdog");
		sos.demoArgumentMatchers(2, "catnap", "anything");
	}

}
