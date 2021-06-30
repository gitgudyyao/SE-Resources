package my.edu.utar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.SortUtilities;
import my.edu.utar.Student;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SortUtilitiesUnitTests {
	
	SortUtilities su = new SortUtilities();

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
	
	private Object[] getParamsForTestSortOnSubject() {
		
		Student[] expectedResult1 = new Student[] {s2,s4,s3}; // sort on maths mark
		Student[] expectedResult2 = new Student[] {s3,s2,s1,s4,s5}; // sort on art mark
		Student[] expectedResult3 = new Student[] {s3,s2,s1}; // sort on english mark
		Student[] expectedResult4 = new Student[] {}; // sort on history
		Student[] expectedResult5 = new Student[] {s3, s2, s4, s5, s1}; // sort on descending total mark
		Student[] expectedResult6 = new Student[] {s5,s3,s4,s2,s1}; // sort on ascending alphabetical order 
		
		return new Object[] {
				new Object[] {"maths", expectedResult1},
				new Object[] {"art",  expectedResult2},
				new Object[] {"english", expectedResult3},
				new Object[] {"history", expectedResult4},
				new Object[] {"total", expectedResult5},
				new Object[] {"name", expectedResult6}
			};
	}
	
	
	@Test
	@Parameters(method = "getParamsForTestSortOnSubject")
	public void paramTestSortOnSubject(String subjectName, Student[] expectedResult) {
		
		Student[] inputArray = new Student[] {s1,s2,s3,s4,s5};
		ArrayList<Student> inputList = new ArrayList<Student>(Arrays.asList(inputArray));

		ArrayList<Student> outputList = null;
		
		if (subjectName.equals("total")) 
			outputList = su.sortOnTotalMark(inputList);
		else if (subjectName.equals("name"))
			outputList = su.sortOnName(inputList);
		else 
			outputList = su.sortOnSubject(inputList,subjectName);
		
		Student[] outputArray = new Student[outputList.size()];
		outputArray = outputList.toArray(outputArray);
		
		assertArrayEquals(expectedResult, outputArray);
	
	}	
	
	
	private Object[] getParamsForTestFilterOnSubjectNames() {
		
		Student[] expectedResult1 = new Student[] {s1,s2,s3}; // filter on: english
		Student[] expectedResult2 = new Student[] {s4,s5}; // filter on: science malay
		Student[] expectedResult3 = new Student[] {s1,s5}; // filter on: geography art
		Student[] expectedResult4 = new Student[] {s2,s3}; // filter on: english maths malay
		Student[] expectedResult5 = new Student[] {}; // filter on: history
		
		return new Object[] {
				new Object[] {new String[] {"english"}, expectedResult1},
				new Object[] {new String[] {"science","malay"},  expectedResult2},
				new Object[] {new String[] {"geography","art"}, expectedResult3},
				new Object[] {new String[] {"english", "maths", "malay"}, expectedResult4},
				new Object[] {new String[] {"history"},expectedResult5}

			};
	}	
	

	@Test
	@Parameters(method = "getParamsForTestFilterOnSubjectNames")
	public void paramTestFilterOnSubjectNames(String[] subjectNames, Student[] expectedResult) {
		
		Student[] inputArray = new Student[] {s1,s2,s3,s4,s5};
		
		ArrayList<Student> outputList = su.filterOnSubjectNames(
				new ArrayList<Student>(Arrays.asList(inputArray)),subjectNames);
		
		Student[] outputArray = new Student[outputList.size()];
		outputArray = outputList.toArray(outputArray);
		
		assertArrayEquals(expectedResult, outputArray);
	
	}	
	
	
}
