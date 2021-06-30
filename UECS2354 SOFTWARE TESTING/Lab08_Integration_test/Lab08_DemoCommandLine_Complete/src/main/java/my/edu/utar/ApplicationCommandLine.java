package my.edu.utar;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class DisplayUtilities {
	
	Scanner input = new Scanner(System.in);
	
	public void showToScreen(String message) {
		System.out.print(message);
	}
	
	public String getFromScreen() {
		return input.nextLine();
	}
}

public class ApplicationCommandLine {
	
	static final String mainMenuDisplayMessage = "\n** MAIN MENU *** \n"
			+ "[1] Read original records from file \n"
			+ "[2] Display original records \n"
			+ "[3] Display selected records \n"
			+ "[4] Filter original to get selected \n"
			+ "[5] Sort original to get selected \n"
			+ "[6] Write selected records to file \n"
			+ "[7] Exit \n"
			+ "Enter your choice : ";	
	
	private StudentRecordApplication sra;
	private FileUtilities fu;
	private SortUtilities su;
	private DisplayUtilities du;

	public ApplicationCommandLine(DisplayUtilities du) {
		fu = new FileUtilities();
		su = new SortUtilities();
		sra = new StudentRecordApplication(fu,su);
		this.du = du;
	}
	
	public void performRecordInitialization() {

		du.showToScreen("Enter file name to read from : ");
		String fileName = du.getFromScreen();
		if (fileName.equals(""))
			return;
		
		try {
			sra.initializeRecordsFromFile(fileName);
		}
		catch (IllegalArgumentException iae) {
			du.showToScreen(iae.getMessage());
		}
	}
	
	public void performRecordSaving() {
		
		du.showToScreen("Enter file name to write to : ");
		String fileName = du.getFromScreen();
		if (fileName.equals(""))
			return;						
		
		try {
			sra.writeSelectedRecordsToFile(fileName);
		}
		catch (IllegalArgumentException iae) {
			du.showToScreen(iae.getMessage());
		}		
	}
	
	public void getInfoForFilterOperation() {

		du.showToScreen("Enter string to filter on : ");
		String filterString = du.getFromScreen();
		if (filterString.equals(""))
			return;
		
		try {
			sra.performFilterOperation(filterString);
		}
		catch (IllegalArgumentException iae) {
			du.showToScreen(iae.getMessage());
		}			
	}
	
	public void getInfoForSortOperation() {
		
		du.showToScreen("Enter item to sort on : ");
		String sortItem = du.getFromScreen();
		if (sortItem.equals(""))
			return;	
		
		try {
			sra.performSortOperation(sortItem);
		}
		catch (IllegalArgumentException iae) {
			du.showToScreen(iae.getMessage());
		}		
	}	
	
	public void mainMenu() {
		String userChoice;
		do {
			du.showToScreen(mainMenuDisplayMessage);
			userChoice = du.getFromScreen();
			String toShow;
			switch (userChoice) {

			case "1" : performRecordInitialization();
				break;
			
			case "2" : toShow = sra.getOriginalRecordsAsString();
				if (toShow == null)
					du.showToScreen("Empty at the moment");
				else
					du.showToScreen(toShow);
				break;
			
			case "3" :  toShow = sra.getSelectedRecordsAsString();
				if (toShow == null)
					du.showToScreen("Empty at the moment");
				else
					du.showToScreen(toShow);
				break;
			
			case "4" : getInfoForFilterOperation();
				break;
			
			case "5" : getInfoForSortOperation();
				break;
			
			case "6" : performRecordSaving();
				break;
			
			case "7" :
				break;
			
			default : du.showToScreen("Invalid option !");
			}
		} while (!userChoice.equals("7"));		
	}	
	
	public static void main( String[] args )
	{ 
		ApplicationCommandLine appCommandLine = new ApplicationCommandLine(new DisplayUtilities()); 
		appCommandLine.mainMenu();
	} 	
}
