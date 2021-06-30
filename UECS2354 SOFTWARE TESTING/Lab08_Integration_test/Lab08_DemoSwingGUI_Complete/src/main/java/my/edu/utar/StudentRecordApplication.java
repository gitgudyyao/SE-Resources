package my.edu.utar;

import java.util.ArrayList;

public class StudentRecordApplication {
	
	String[] subjectList = {"malay", "english", "geography",  "science", "maths", "art", "history"};
			
	FileUtilities fu;
	SortUtilities su;
	ArrayList<Student> studentRecords = null;
	ArrayList<Student> selectedRecords = null;
	
	public StudentRecordApplication(FileUtilities fu, SortUtilities su) {
		this.fu = fu;
		this.su = su;
	}
	
	public void setStudentRecords(ArrayList<Student> studentRecords) {
		this.studentRecords = studentRecords;
	}
	
	public void setSelectedRecords(ArrayList<Student> selectedRecords) {
		this.selectedRecords = selectedRecords;
	}
	
	public ArrayList<Student> getStudentRecords() {
		return studentRecords;
		
	}
	
	public ArrayList<Student> getSelectedRecords() {
		return selectedRecords;
	}
	
	
	public boolean isValidSubjectName(String[] words) {
		
		int numMatch = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < subjectList.length; j++) {
				if (words[i].equals(subjectList[j])) {
					numMatch++;
					break;
				}
			}
		}
		if (numMatch == words.length)
			return true;
		else 
			return false;
	}
	
	public void performSortOperation(String itemToSort) {

		if (studentRecords == null)
			throw new IllegalArgumentException("Student records have not being read in yet !");
		
		String[] words = itemToSort.trim().toLowerCase().split("\\W+");
		if (words.length > 1)
			throw new IllegalArgumentException("Only one sort item can be specified");
		
		ArrayList<Student> tempResults=null;

		if (itemToSort.equals("name")) 
			tempResults = su.sortOnName(studentRecords);
		else if (itemToSort.equals("total"))
			tempResults = su.sortOnTotalMark(studentRecords);
		else if (isValidSubjectName(words))
			tempResults = su.sortOnSubject(studentRecords, itemToSort);
		else 
			throw new IllegalArgumentException("That is not a valid item to sort on");
		
		if (tempResults.size() == 0)
			throw new IllegalArgumentException("No records match specified item");
		else
			selectedRecords = tempResults;

	}
	
	
	public void performFilterOperation(String filterString) {
		
		if (studentRecords == null)
			throw new IllegalArgumentException("Student records have not being read in yet !");
		
		ArrayList<Student> tempResults=null;
		
		String [] words = filterString.toLowerCase().split("\\W+");
		if (isValidSubjectName(words)) 
			tempResults = su.filterOnSubjectNames(studentRecords, words);
		else
			throw new IllegalArgumentException("String contains invalid item to filter on");
		
		if (tempResults.size() == 0)
			throw new IllegalArgumentException("No records match items in filter string");
		else
			selectedRecords = tempResults;
	}
	
	public String getOriginalRecordsAsString() {
		if (studentRecords == null) {
			return null;
		}	
		String recordString = "";
		for (Student stud : studentRecords)
			recordString += stud + "\n";
		return recordString;
		
	}
		
	public String getSelectedRecordsAsString() {
		if (selectedRecords == null) {
			return null;
		}	
		String recordString = "";
		for (Student stud : selectedRecords)
			recordString += stud + "\n";
		return recordString;		
	}
	
	public void writeSelectedRecordsToFile(String fileName) {
		
		if (selectedRecords == null) 
			throw new IllegalArgumentException("Error ! No records have being selected yet !");
		
		ArrayList<String> recordStrings = new ArrayList<>();
		String outputString;
		String[] subjectsTaken;
		int[] subjectMark;
				
		for (Student student : selectedRecords) {
			outputString = student.getName();
			subjectsTaken = student.getSubjectsTaken();
			subjectMark = student.getSubjectMark();
			for (int i = 0;i < subjectsTaken.length; i++)
				outputString += "\t" + subjectsTaken[i] + ":" + subjectMark[i];
			recordStrings.add(outputString);
		}
		String[] strArray = new String[recordStrings.size()];
		strArray = recordStrings.toArray(strArray);
		
		fu.writeStringsToFile(strArray, fileName);
	}
	
	
	public void initializeRecordsFromFile(String fileName) {

		String[] stringsRead = null; 

		stringsRead = fu.readStringsFromFile(fileName);

		String[] subjectsTaken, items;
		int[] subjectMark;
		int arrayPos;
		Student student;
		studentRecords = new ArrayList<>();
		
		for (String line : stringsRead) {
			
			items = line.split("\\W+");
				
			subjectsTaken = new String[4];
			subjectMark = new int[4];
			arrayPos = 0;
			for (int i = 1; i < 8; i += 2)
				subjectsTaken[arrayPos++] = items[i];
			
			arrayPos = 0;
			for (int i = 2; i < 9; i += 2)
				subjectMark[arrayPos++] = Integer.parseInt(items[i]);
			student = new Student(items[0],subjectsTaken,subjectMark);
			studentRecords.add(student);
		}
	}
	

}
