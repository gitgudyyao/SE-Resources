package my.edu.utar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class ValueComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getValToCompare() > o2.getValToCompare())
			return -1;
		else if (o1.getValToCompare() < o2.getValToCompare())
			return 1;
		else 
			return 0;
	}
}


public class SortUtilities {
	
	public ArrayList<Student> sortOnName(List<Student> selectedRecords) {
		
		ArrayList<Student> tempList = new ArrayList<>(selectedRecords);
		Collections.sort(tempList, new StudentNameComparator());
		return tempList;
	}

	public ArrayList<Student> sortOnTotalMark(List<Student> selectedRecords) {
		
		ArrayList<Student> tempList = new ArrayList<>();
		Student newStudent;
		
		for (Student tempStudent : selectedRecords) {
			newStudent = new Student(tempStudent);
			int[] subjectMark = newStudent.getSubjectMark();
			int totalMark = 0;
			for (int i = 0; i < subjectMark.length; i++)
				totalMark += subjectMark[i];
			newStudent.setValToCompare(totalMark);
			tempList.add(newStudent);
		}
		
		Collections.sort(tempList, new ValueComparator());
		return tempList;
	}

	
	public ArrayList<Student> sortOnSubject(List<Student> selectedRecords, String subjectName) {
		
		ArrayList<Student> tempList = new ArrayList<>();
		Student newStudent;

		for (Student tempStudent : selectedRecords) {
			newStudent = new Student(tempStudent);
			String[] subjectsTaken = newStudent.getSubjectsTaken();
			for (int i = 0; i < subjectsTaken.length; i++) {

				if (subjectName.equals(subjectsTaken[i])) {
					int[] subjectMark = newStudent.getSubjectMark();
					newStudent.setValToCompare(subjectMark[i]);
					tempList.add(newStudent);
					break;
				}
			}
		}
		
		Collections.sort(tempList, new ValueComparator());
		return tempList;
	}

	public ArrayList<Student> filterOnSubjectNames(List<Student> selectedRecords, String[] subjectNames) 
	{
	
		ArrayList<Student> tempList = new ArrayList<>();
		int matchName;

		for (Student tempStudent : selectedRecords) {
			matchName = 0;
			String[] subjectsTaken = tempStudent.getSubjectsTaken();
			for (String subjectCompare : subjectNames) {
				for (String subjectTaken : subjectsTaken){
					if (subjectTaken.equals(subjectCompare)) {
						matchName++;
						break;
					}
				}
			}
			if (matchName == subjectNames.length) {
				tempList.add(new Student(tempStudent));
			}
			
		}
		return tempList;
	}
	


}
