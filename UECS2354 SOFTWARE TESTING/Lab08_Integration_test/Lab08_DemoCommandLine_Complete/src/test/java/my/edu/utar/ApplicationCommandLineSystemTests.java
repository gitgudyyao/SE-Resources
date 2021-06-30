package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.ApplicationCommandLine;
import my.edu.utar.DisplayUtilities;

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

@RunWith(JUnitParamsRunner.class)

public class ApplicationCommandLineSystemTests {
	
	static final String mainMenuDisplayMessage = "\n** MAIN MENU *** \n"
			+ "[1] Read original records from file \n"
			+ "[2] Display original records \n"
			+ "[3] Display selected records \n"
			+ "[4] Filter original to get selected \n"
			+ "[5] Sort original to get selected \n"
			+ "[6] Write selected records to file \n"
			+ "[7] Exit \n"
			+ "Enter your choice : ";
		
	DisplayUtilities duMock;
	ApplicationCommandLine acl;

	@Before
	public void setupForAllTests() {
		duMock = mock(DisplayUtilities.class);
		acl = new ApplicationCommandLine(duMock);
	}	
	
	private Object[] getParamsForCommandLineTestRun() {
		
		String[] expectedResult1 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage,
				"Vicky	english:10	geography:20	malay:30	art:40\n" +
				"Peter	english:50	maths:90	malay:15	art:50\n" +
				"Carmen	english:80	maths:15	malay:50	art:90\n" +
				"Melanie	science:10	maths:60	malay:80	art:20\n" +
				"Albert	science:30	geography:25	malay:70	art:10\n",				
		mainMenuDisplayMessage
		};				

		String[] expectedResult2 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage, "Enter item to sort on : ", mainMenuDisplayMessage, 
				"Carmen	english:80	maths:15	malay:50	art:90\n" +
				"Peter	english:50	maths:90	malay:15	art:50\n" +
				"Melanie	science:10	maths:60	malay:80	art:20\n" +
				"Albert	science:30	geography:25	malay:70	art:10\n" +				
				"Vicky	english:10	geography:20	malay:30	art:40\n",

		mainMenuDisplayMessage
		};				
		
		String[] expectedResult3 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage, "Enter item to sort on : ", mainMenuDisplayMessage, 
				"Albert	science:30	geography:25	malay:70	art:10\n" +				
				"Carmen	english:80	maths:15	malay:50	art:90\n" +
				"Melanie	science:10	maths:60	malay:80	art:20\n" +
				"Peter	english:50	maths:90	malay:15	art:50\n" +
				"Vicky	english:10	geography:20	malay:30	art:40\n",
		mainMenuDisplayMessage
		};				
		
		String[] expectedResult4 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage, "Enter item to sort on : ", mainMenuDisplayMessage,
				"Carmen	english:80	maths:15	malay:50	art:90\n" +
				"Peter	english:50	maths:90	malay:15	art:50\n" +
				"Vicky	english:10	geography:20	malay:30	art:40\n",
		mainMenuDisplayMessage
		};				

		String[] expectedResult5 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage, "Enter string to filter on : ", mainMenuDisplayMessage, 
				"Melanie	science:10	maths:60	malay:80	art:20\n" +
				"Albert	science:30	geography:25	malay:70	art:10\n",				
		mainMenuDisplayMessage
		};				

		String[] expectedResult6 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage, "Enter string to filter on : ", mainMenuDisplayMessage, 
				"Peter	english:50	maths:90	malay:15	art:50\n" +
				"Carmen	english:80	maths:15	malay:50	art:90\n",
		mainMenuDisplayMessage
		};				
		
		String[] expectedResult7 = new String[] {mainMenuDisplayMessage, "Enter file name to read from : ", 
				"File does not exist : crazyname", mainMenuDisplayMessage, "Enter file name to read from : ", 
				mainMenuDisplayMessage,"Invalid option !",
				mainMenuDisplayMessage,"Empty at the moment",
				mainMenuDisplayMessage, "Enter string to filter on : ", 
				"String contains invalid item to filter on", mainMenuDisplayMessage,
				"Enter item to sort on : ", "That is not a valid item to sort on", 
				mainMenuDisplayMessage, "Empty at the moment",
				mainMenuDisplayMessage
		};
		
		return new Object[] {
				
				new Object[] {1,expectedResult1},
				new Object[] {2,expectedResult2},
				new Object[] {3,expectedResult3},
				new Object[] {4,expectedResult4},
				new Object[] {5,expectedResult5},
				new Object[] {6,expectedResult6},
				new Object[] {7,expectedResult7}
		};		
	}
	
	@Test
	@Parameters(method = "getParamsForCommandLineTestRun")
	public void commandLineTestRun(int testRunNum, String[] expectedResults) {
		
		// All test runs except the last one commence with reading in records 
		// from simpletestfile.txt		
		
		// Display the records just read in 
		if (testRunNum == 1)
			when(duMock.getFromScreen()).thenReturn("1", "simpletestfile.txt", "2", "7");
		
		// Sort the records on total marks, and display the selected records 
		else if (testRunNum == 2)
			when(duMock.getFromScreen()).thenReturn("1", "simpletestfile.txt", 
					"5", "total", "3", "7");
		
		// Sort the records on name, and display the selected records 
		else if (testRunNum == 3)
			when(duMock.getFromScreen()).thenReturn("1", "simpletestfile.txt", 
					"5", "name", "3", "7");
		
		// Sort the records on the english subject, and display the selected records 
		else if (testRunNum == 4)
			when(duMock.getFromScreen()).thenReturn("1", "simpletestfile.txt", 
					"5", "english", "3", "7");
		
		// Filter the records on science and malay, and display the selected records 
		else if (testRunNum == 5)
			when(duMock.getFromScreen()).thenReturn("1", "simpletestfile.txt", 
					"4", "science malay", "3", "7");
		
		// Filter the records on english, maths and malay, and display the selected records 
		else if (testRunNum == 6)
			when(duMock.getFromScreen()).thenReturn("1", "simpletestfile.txt", 
					"4", "english maths malay", "3", "7");
		
		// Test run to check whether the appropriate error messages are displayed 
		// for invalid user inputs
		else if (testRunNum == 7)
			when(duMock.getFromScreen()).thenReturn("1", "crazyname", "1", 
					"simpletestfile.txt", "9", "3","4","total","5", "arts", "3", "7");
			
		acl.mainMenu();

		InOrder inOrder = inOrder(duMock);
		
		for (int i = 0; i < expectedResults.length; i++)
			inOrder.verify(duMock).showToScreen(expectedResults[i]);			
	}
}
