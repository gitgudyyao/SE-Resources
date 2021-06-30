package my.edu.utar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.FileUtilities;
import my.edu.utar.SortUtilities;
import my.edu.utar.StudentRecordApplication;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ApplicationGUISystemTests {
	
	FileUtilities fu;
	SortUtilities su;
	StudentRecordApplication sra;

	@Before
	public void setupForAllTests() {
		fu = new FileUtilities();
		su = new SortUtilities();
		sra = new StudentRecordApplication(fu,su);
	}		

	private Object[] getParamsForGUITestRun() {
		
		return new Object[] {
				
				new Object[] {1, new String[] {
					"Vicky	english:10	geography:20	malay:30	art:40",
					"Peter	english:50	maths:90	malay:15	art:50",
					"Carmen	english:80	maths:15	malay:50	art:90",
					"Melanie	science:10	maths:60	malay:80	art:20",
					"Albert	science:30	geography:25	malay:70	art:10"}, 
					new String[] {}
				},

				new Object[] {2, new String[] {}, new String[] {
					"Carmen	english:80	maths:15	malay:50	art:90",
					"Peter	english:50	maths:90	malay:15	art:50",
					"Melanie	science:10	maths:60	malay:80	art:20",
					"Albert	science:30	geography:25	malay:70	art:10", 
					"Vicky	english:10	geography:20	malay:30	art:40"}
				},
				
				new Object[] {3, new String[] {}, new String[] {
					"Albert	science:30	geography:25	malay:70	art:10", 
					"Carmen	english:80	maths:15	malay:50	art:90",
					"Melanie	science:10	maths:60	malay:80	art:20",
					"Peter	english:50	maths:90	malay:15	art:50",
					"Vicky	english:10	geography:20	malay:30	art:40"}
				},
				
				new Object[] {4, new String[] {}, new String[] {
					"Carmen	english:80	maths:15	malay:50	art:90",
					"Peter	english:50	maths:90	malay:15	art:50",
					"Vicky	english:10	geography:20	malay:30	art:40"}
				},
				
				new Object[] {5, new String[] {}, new String[] {
					"Melanie	science:10	maths:60	malay:80	art:20",
					"Albert	science:30	geography:25	malay:70	art:10"}
				},

				new Object[] {6, new String[] {}, new String[] {
					"Peter	english:50	maths:90	malay:15	art:50",
					"Carmen	english:80	maths:15	malay:50	art:90"}
				}
		};		
	}
	
	@Test
	@Parameters(method = "getParamsForGUITestRun")
	public void GUITestRun(int testRunNum, String[] originalStrArray, String[] selectedStrArray) {
		
		String expectedOriginalString = "";
		for (String s : originalStrArray) 
			expectedOriginalString += s + "\n";
		
		String expectedSelectedString = "";
		for (String s : selectedStrArray) 
			expectedSelectedString += s + "\n";
		
		// Display the records just read in 
		if (testRunNum == 1) {
			
			sra.initializeRecordsFromFile("simpletestfile.txt");
			String originalRecordsString = sra.getOriginalRecordsAsString();
			assertEquals(expectedOriginalString, originalRecordsString);
		}
		
		// Sort the records on total marks, and display the selected records 
		else if (testRunNum == 2) {
			
			sra.initializeRecordsFromFile("simpletestfile.txt");
			sra.performSortOperation("total");
			String selectedRecordsString = sra.getSelectedRecordsAsString();
			assertEquals(expectedSelectedString, selectedRecordsString);			
		}

		// Sort the records on name, and display the selected records 
		else if (testRunNum == 3) {

			sra.initializeRecordsFromFile("simpletestfile.txt");
			sra.performSortOperation("name");
			String selectedRecordsString = sra.getSelectedRecordsAsString();
			assertEquals(expectedSelectedString, selectedRecordsString);			
		}
		
		// Sort the records on the english subject, and display the selected records 
		else if (testRunNum == 4) {

			sra.initializeRecordsFromFile("simpletestfile.txt");
			sra.performSortOperation("english");
			String selectedRecordsString = sra.getSelectedRecordsAsString();
			assertEquals(expectedSelectedString, selectedRecordsString);			
		}
		
		// Filter the records on science and malay, and display the selected records 
		else if (testRunNum == 5) {

			sra.initializeRecordsFromFile("simpletestfile.txt");
			sra.performFilterOperation("science malay");
			String selectedRecordsString = sra.getSelectedRecordsAsString();
			assertEquals(expectedSelectedString, selectedRecordsString);			
		}
		
		// Filter the records on english, maths and malay, and display the selected records 
		else if (testRunNum == 6) {

			sra.initializeRecordsFromFile("simpletestfile.txt");
			sra.performFilterOperation("english maths malay");
			String selectedRecordsString = sra.getSelectedRecordsAsString();
			assertEquals(expectedSelectedString, selectedRecordsString);			
		}		
	}
}
