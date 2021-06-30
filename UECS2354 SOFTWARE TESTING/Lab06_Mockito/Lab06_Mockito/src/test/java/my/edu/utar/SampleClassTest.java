package my.edu.utar;

import static org.mockito.Mockito.*;
import org.junit.Test;

import my.edu.utar.FileReaderClass;
import my.edu.utar.FileWriterClass;
import my.edu.utar.SampleClass;

public class SampleClassTest {
	
	@Test
	public void testSampleMethod() {
		
		FileReaderClass frc = new FileReaderClass();
		FileWriterClass fwc = new FileWriterClass();
		FileReaderClass readSpy = spy(frc);
		FileWriterClass writeSpy = spy(fwc);
		
		//FileReaderClass readSpy = mock(FileReaderClass.class);
		//FileWriterClass writeSpy = mock(FileWriterClass.class);
		
		// setting up a spy to return a value in place of the actual method
		when(readSpy.getNumberFromFile()).thenReturn(100);
				
		SampleClass sc = new SampleClass(readSpy, writeSpy);
		sc.sampleMethod();
		
		// verify the actual method was called 5 times with the value 100
		verify(writeSpy, times(5)).writeDataToFile(100);
	}
}
