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
import static org.mockito.Mockito.doThrow;



@RunWith(JUnitParamsRunner.class)

public class StudentRecordApplicationUnitTests {
	
	FileUtilities fuMock;
	SortUtilities suMock;
	StudentRecordApplication sra;
	
	
	Student s1 = new Student("Vicky", new String[]{"english","maths","malay","art"},
			new int[] {10,10,10,10});
	Student s2 = new Student("Peter", new String[]{"science","geography","history","art"},
			new int[] {30,30,30,30});
	Student s3 = new Student("Carmen", new String[]{"art","english","science","maths"},
			new int[] {20,20,20,20});	

	@Before
	public void setupForAllTests() {
		fuMock = mock(FileUtilities.class);
		suMock = mock(SortUtilities.class);	
		sra = new StudentRecordApplication(fuMock,suMock);

	}	

	private Object[] getParamsForTestIsValidSubjectName() {
		return new Object[] {
				
				new Object[] {new String[]{"maths"},true},
				new Object[] {new String[]{"science"},true},
				new Object[] {new String[]{"english","history"},true},
				new Object[] {new String[]{"geography","malay"},true},
				new Object[] {new String[]{"mathss"},false},
				new Object[] {new String[]{"maths","arts"},false},
				new Object[] {new String[]{"english","his"},false}
		
		};		
	}
	
	@Test
	@Parameters(method = "getParamsForTestIsValidSubjectName")
	public void testIsValidSubjectName(String[] words, boolean expectedResult) {
		
		boolean result = sra.isValidSubjectName(words);
		assertEquals(expectedResult, result);
		
	}
	
	
	private Object[] getParamsForTestPerformSortOperation() {
		return new Object[] {"name","total","malay","english","geography",
				"science","maths","art"," history"};		
	}

	
	@Test
	@Parameters(method = "getParamsForTestPerformSortOperation")
	public void testPerformSortOperation(String itemToSort) {
		
		ArrayList<Student> listToUse = new ArrayList<Student>();
		listToUse.add(s1);
		listToUse.add(s2);
		listToUse.add(s3);
		
		Student[] listToUseArray = new Student[listToUse.size()];
		listToUseArray = listToUse.toArray(listToUseArray);

		sra.setStudentRecords(listToUse); 

		// set the selected records in sra to null to check that calling
		// performSortOperation will set it to the new value of listValue
		sra.setSelectedRecords(null);
		
		// setup so that all the methods when called will return the 
		// Student ArrayList we set up earlier
		when(suMock.sortOnName(anyListOf(Student.class))).thenReturn(listToUse);	
		when(suMock.sortOnTotalMark(anyListOf(Student.class))).thenReturn(listToUse);	
		when(suMock.sortOnSubject(anyListOf(Student.class),anyString())).thenReturn(listToUse);	
		
		sra.performSortOperation(itemToSort);
		
		if (itemToSort.equals("name")) {
			verify(suMock, never()).sortOnTotalMark(anyListOf(Student.class));
			verify(suMock, never()).sortOnSubject(anyListOf(Student.class), anyString());
		}
		else if (itemToSort.equals("total")) {
			verify(suMock, never()).sortOnName(anyListOf(Student.class));
			verify(suMock, never()).sortOnSubject(anyListOf(Student.class), anyString());
		}
		else {
			verify(suMock, never()).sortOnName(anyListOf(Student.class));
			verify(suMock, never()).sortOnTotalMark(anyListOf(Student.class));
		}
		
		//get StudentRecords back to perform comparison
		ArrayList<Student> selectedRecords = sra.getSelectedRecords();
		Student[] selectedRecordArray = new Student[selectedRecords.size()];
		selectedRecordArray = selectedRecords.toArray(selectedRecordArray);
		
		assertArrayEquals(listToUseArray, selectedRecordArray);
	}

	// testing for exception when studentRecords is null
	@Test(expected=IllegalArgumentException.class)
	public void testPerformSortOperationError1() {
		
		sra.performSortOperation("history");
	
	}	
	
	// testing for exception when incorrect sort item is specified 
	// or more than one sort item is specified
	private Object[] getParamsForTestPerformSortOperationError2() {
		return new Object[] {"totals","art maths","total art", "cat", "englishe"};		
	}

	@Test(expected=IllegalArgumentException.class)
	@Parameters(method = "getParamsForTestPerformSortOperationError2")
	public void testPerformSortOperationError2(String itemToSort) {

		ArrayList<Student> listToUse = new ArrayList<Student>();
		listToUse.add(s1);
		listToUse.add(s2);
		listToUse.add(s3);
		
		Student[] listToUseArray = new Student[listToUse.size()];
		listToUseArray = listToUse.toArray(listToUseArray);

		sra.setStudentRecords(listToUse); 

		// set the selected records in sra to null to check that calling
		// performSortOperation will set it to the new value of listValue
		sra.setSelectedRecords(null);
		
		// setup so that all the methods when called will return the 
		// Student ArrayList we set up earlier
		when(suMock.sortOnName(anyListOf(Student.class))).thenReturn(listToUse);	
		when(suMock.sortOnTotalMark(anyListOf(Student.class))).thenReturn(listToUse);	
		when(suMock.sortOnSubject(anyListOf(Student.class),anyString())).thenReturn(listToUse);	
		
		sra.performSortOperation(itemToSort);
	
	}	

	// testing for exception when no records match specified item
	@Test(expected=IllegalArgumentException.class)
	public void testPerformSortOperationError3() {
		
		ArrayList<Student> listToUse = new ArrayList<Student>();
		when(suMock.sortOnName(anyListOf(Student.class))).thenReturn(listToUse);	

		sra.performSortOperation("history");
	
	}		
	
	
	private Object[] getParamsForTestPerformFilterOperation() {
		return new Object[] {"malay","science maths","art history geography"};		
	}
	
	@Test
	@Parameters(method = "getParamsForTestPerformFilterOperation")
	public void testperformFilterOperation(String filterString) {

		ArrayList<Student> listToUse = new ArrayList<Student>();
		listToUse.add(s1);
		listToUse.add(s2);
		listToUse.add(s3);
		sra.setStudentRecords(listToUse); 

		
		Student[] listToUseArray = new Student[listToUse.size()];
		listToUseArray = listToUse.toArray(listToUseArray);

		// set the selected records in sra to null to check that calling
		// performSortOperation will set it to the new value of listValue
		sra.setSelectedRecords(null);

		String[] filterArgs = filterString.toLowerCase().split("\\W+");
		
		// setup so that filterOnSubjectNames will return the 
		// Student ArrayList we set up earlier if called with the correct
		// string array filterArgs
		when(suMock.filterOnSubjectNames(anyListOf(Student.class), eq(filterArgs))).thenReturn(listToUse);
		
		sra.performFilterOperation(filterString);
		
		//get StudentRecords back to perform comparison
		ArrayList<Student> selectedRecords = sra.getSelectedRecords();
		Student[] selectedRecordArray = new Student[selectedRecords.size()];
		selectedRecordArray = selectedRecords.toArray(selectedRecordArray);
		
		assertArrayEquals(listToUseArray, selectedRecordArray);
	}
	
	// testing for exception when studentRecords is null
	@Test(expected=IllegalArgumentException.class)
	public void testPerformFilterOperationError1() {
		
		sra.performFilterOperation("history");
	
	}		
	
	// testing for exception when incorrect item is specified in filter string
	private Object[] getParamsForTestPerformFilterOperationError2() {
		return new Object[] {"malays","science mathss","ar malay"};		
	}

	@Test(expected=IllegalArgumentException.class)
	@Parameters(method = "getParamsForTestPerformFilterOperationError2")
	public void testperformFilterOperationError2(String filterString) {
		
		ArrayList<Student> listToUse = new ArrayList<Student>();
		listToUse.add(s1);
		listToUse.add(s2);
		listToUse.add(s3);
		sra.setStudentRecords(listToUse); 
		
		String[] filterArgs = filterString.toLowerCase().split("\\W+");
		
		// setup so that filterOnSubjectNames will return the 
		// Student ArrayList we set up earlier if called with the correct
		// string array filterArgs
		when(suMock.filterOnSubjectNames(anyListOf(Student.class), eq(filterArgs))).thenReturn(listToUse);

		sra.performFilterOperation(filterString);
	
	}
	
	// testing for exception when no records match specified item
	@Test(expected=IllegalArgumentException.class)
	public void testPerformFilterOperationError3() {
		
		ArrayList<Student> listToUse = new ArrayList<Student>();
		
		when(suMock.filterOnSubjectNames(anyListOf(Student.class), any(String[].class))).
		thenReturn(listToUse);

		sra.performFilterOperation("history");
	
	}	
	
	
	private Object[] getParamsForTestGetRecordsAsString() {
		
		Student[] inputArray = new Student[] {s1, s2, s3};
		
		String[] expectedResults1 = new String[] {"Vicky	english:10	maths:10	malay:10	art:10",
				"Peter	science:30	geography:30	history:30	art:30",
				"Carmen	art:20	english:20	science:20	maths:20"};
		
		return new Object[] { 
				
				new Object[] {inputArray, expectedResults1},
				new Object[] {null, null}
		
		};		
	}
	
	@Test
	@Parameters(method = "getParamsForTestGetRecordsAsString")
	public void testGetOriginalRecordsAsString(Student[] inputArray, String[] expectedResults) {
		
		
		if (inputArray == null) {
			sra.setStudentRecords(null);
			String displayString = sra.getOriginalRecordsAsString();
			assertNull(displayString);
		}
		else {

			ArrayList<Student> studentRecords = new ArrayList<Student>(Arrays.asList(inputArray));
			sra.setStudentRecords(studentRecords);
			String displayString = sra.getOriginalRecordsAsString();
			String expectedString = "";
			for (String s : expectedResults)
				expectedString += s + "\n";
			assertEquals(expectedString, displayString);
		}

	}
	
	
	@Test
	@Parameters(method = "getParamsForTestGetRecordsAsString")
	public void testGetSelectedRecordsAsString(Student[] inputArray, String[] expectedResults) {
		
		if (inputArray == null) {
			sra.setSelectedRecords(null);
			String displayString = sra.getSelectedRecordsAsString();
			assertNull(displayString);		
			
		}
		else {
			ArrayList<Student> studentRecords = new ArrayList<Student>(Arrays.asList(inputArray));
			sra.setSelectedRecords(studentRecords);
			String displayString = sra.getSelectedRecordsAsString();
			String expectedString = "";
			for (String s : expectedResults)
				expectedString += s + "\n";
			assertEquals(expectedString, displayString);			
		}
	}


	@Test
	public void testWriteSelectedRecordsToFile() {	
		
		ArrayList<Student> selectedRecords = new ArrayList<Student>();
		selectedRecords.add(s1);
		selectedRecords.add(s2);
		selectedRecords.add(s3);
		
		sra.setSelectedRecords(selectedRecords);
		
		sra.writeSelectedRecordsToFile("dummyfilename");
		
		String[] expectedResults = new String[] {
				"Vicky	english:10	maths:10	malay:10	art:10",
				"Peter	science:30	geography:30	history:30	art:30",
				"Carmen	art:20	english:20	science:20	maths:20"
		};
		
		verify(fuMock).writeStringsToFile(expectedResults, "dummyfilename");		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWriteSelectedRecordsToFileError1() {
		
		sra.setSelectedRecords(null);
		sra.writeSelectedRecordsToFile("dummyfilename");
		
	}		
	
	@Test(expected=IllegalArgumentException.class)
	public void testWriteSelectedRecordsToFileError2() {
		
		doThrow(new IllegalArgumentException("Error in file name : crazyfile")).
		when(fuMock).writeStringsToFile(any(String[].class), anyString());
		
		sra.writeSelectedRecordsToFile("dummyfilename");
		
	}	
	
	@Test
	public void testInitializeRecordsFromFile() {
		
		
		String[] testFileStrings = new String [] {"Vicky	english:10	maths:10	malay:10	art:10",
				"Peter	science:30	geography:30	history:30	art:30",
				"Carmen	art:20	english:20	science:20	maths:20"};
		
		when(fuMock.readStringsFromFile("dummyfilename")).thenReturn(testFileStrings);
		
		sra.initializeRecordsFromFile("dummyfilename");
		
		verify(fuMock).readStringsFromFile("dummyfilename");
		
		ArrayList<Student> studentRecords = sra.getStudentRecords();
		
		Student[] recordArray = new Student[studentRecords.size()];
		recordArray = studentRecords.toArray(recordArray);
		
		Student[] expectedResult = new Student[]{s1, s2, s3};
		
		assertArrayEquals(expectedResult, recordArray);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitializeRecordsFromFileError() {
		
		when(fuMock.readStringsFromFile(anyString())).
		thenThrow(new IllegalArgumentException("Error in file name : crazyfilename"));

		sra.initializeRecordsFromFile("crazyfilename");
		
	}

}
