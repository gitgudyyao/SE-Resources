package my.edu.utar;
import java.util.ArrayList;
import java.util.Arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.FileUtilities;
import my.edu.utar.SortUtilities;
import my.edu.utar.Student;
import my.edu.utar.StudentRecordApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyListOf;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.inOrder;


@RunWith(JUnitParamsRunner.class)

public class StudentRecordApplicationIntegrationTests {
	
	FileUtilities fu;
	SortUtilities su;
	StudentRecordApplication sra;

	@Before
	public void setupForAllTests() {
		fu = new FileUtilities();
		su = new SortUtilities();
		sra = new StudentRecordApplication(fu,su);

	}	
	
	Student s1 = new Student("Vicky", new String[]{"english","geography","malay","art"},
			new int[] {10,20,30,40});
	Student s2 = new Student("Peter", new String[]{"english","maths","malay","art"},
			new int[] {50,90,15,50});
	Student s3 = new Student("Carmen", new String[]{"english","maths","malay","art"},
			new int[] {80,15,50,90});
	Student s4 = new Student("Melanie", new String[]{"science","maths","malay","art"},
			new int[] {10,60,80,20});
	Student s5 = new Student("Albert", new String[]{"science","geography","malay","art"},
			new int[] {30,25,70,10});	

	private Object[] getParamsForTestPerformSortOperation() {
		return new Object[] {
				
				// sort on ascending alphabetical order 
				new Object[] {"name", new Student[] {s5,s3,s4,s2,s1}}, 
				
				// sort on descending total mark
				new Object[] {"total", new Student[] {s3, s2, s4, s5, s1}}, 
				
				// sort on maths mark
				new Object[] {"maths", new Student[] {s2,s4,s3}}, 
				
				// sort on art mark
				new Object[] {"art", new Student[] {s3,s2,s1,s4,s5}}, 

				// sort on english mark
				new Object[] {"english", new Student[] {s3,s2,s1}}
		
		};		
	}

	
	@Test
	@Parameters(method = "getParamsForTestPerformSortOperation")
	public void testPerformSortOperation(String itemToSort, Student[] expectedResult) {
		
		Student[] inputArray = new Student[]{s1, s2, s3, s4, s5};
		
		ArrayList<Student> inputList = new ArrayList<Student>(Arrays.asList(inputArray));
		
		// set both the student records and selected records to inputList
		// so that if the sort operation does not return a proper result
		// selected records still has a default value (inputList) to be
		// compared to
		sra.setStudentRecords(inputList);
		sra.setSelectedRecords(inputList);
		
		sra.performSortOperation(itemToSort);
		
		ArrayList<Student> outputList = sra.getSelectedRecords();
		Student[] outputArray = new Student[outputList.size()];
		outputArray = outputList.toArray(outputArray);
		
		assertArrayEquals(expectedResult, outputArray);		
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testPerformSortOperationError() {
		
		Student[] inputArray = new Student[]{s1, s2, s3, s4, s5};
		
		ArrayList<Student> inputList = new ArrayList<Student>(Arrays.asList(inputArray));

		sra.setStudentRecords(inputList);
		
		sra.performSortOperation("history"); // this item does not exist in student records
	
	}		
	
	
	private Object[] getParamsForTestPerformFilterOperation() {
		
		return new Object[] {
				
				// filter on english only
				new Object[] {"english", new Student[] {s1,s2,s3}}, 
				
				// filter on science and malay
				new Object[] {"science malay", new Student[] {s4,s5}}, 
				
				// filter on geography and art
				new Object[] {"geography art", new Student[] {s1,s5}}, 
				
				// filter on english, maths and malay
				new Object[] {"english maths malay", new Student[] {s2,s3}}

		};	
	}
	
	@Test
	@Parameters(method = "getParamsForTestPerformFilterOperation")
	public void testperformFilterOperation(String filterString, Student[] expectedResult) {
		
		Student[] inputArray = new Student[]{s1, s2, s3, s4, s5};
		
		ArrayList<Student> inputList = new ArrayList<Student>(Arrays.asList(inputArray));
		
		// set both the student records and selected records to inputList
		// so that if the sort operation does not return a proper result
		// selected records still has a default value (inputList) to be
		// compared to
		sra.setStudentRecords(inputList);
		sra.setSelectedRecords(inputList);		
		
		sra.performFilterOperation(filterString);
		
		ArrayList<Student> outputList = sra.getSelectedRecords();
		Student[] outputArray = new Student[outputList.size()];
		outputArray = outputList.toArray(outputArray);
		
		assertArrayEquals(expectedResult, outputArray);				
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testPerformFilterOperationError() {
		
		Student[] inputArray = new Student[]{s1, s2, s3, s4, s5};
		
		ArrayList<Student> inputList = new ArrayList<Student>(Arrays.asList(inputArray));

		sra.setStudentRecords(inputList);
		
		sra.performFilterOperation("history"); // this item does not exist in student records
	
	}	

	
	@Test
	public void testWriteSelectedRecordsToFile() {
		
		Student s1 = new Student("Vicky", new String[]{"english","geography","malay","art"},
				new int[] {10,20,30,40});
		Student s2 = new Student("Peter", new String[]{"english","maths","malay","art"},
				new int[] {50,90,15,50});
		Student s3 = new Student("Carmen", new String[]{"english","maths","malay","art"},
				new int[] {80,15,50,90});
		Student s4 = new Student("Melanie", new String[]{"science","maths","malay","art"},
				new int[] {10,60,80,20});
		Student s5 = new Student("Albert", new String[]{"science","geography","malay","art"},
				new int[] {30,25,70,10});
		
		Student[] inputArray = new Student[] {s1,s2,s3,s4,s5};
		ArrayList<Student> selectedRecords = new ArrayList<>(Arrays.asList(inputArray));
		
		sra.setSelectedRecords(selectedRecords);
		
		
		sra.writeSelectedRecordsToFile("dummytest1.txt");
		sra.initializeRecordsFromFile("dummytest1.txt");

		ArrayList<Student> studentRecords = sra.getStudentRecords();
		Student[] studArray = new Student[studentRecords.size()];
		studArray = studentRecords.toArray(studArray);
		
		assertArrayEquals(inputArray,studArray);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitializeRecordsFromFileError() {

		sra.initializeRecordsFromFile("somecrazyfilenamethatdoesnotexist");
		
	}	
	
	

}
