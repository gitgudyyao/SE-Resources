package my.edu.utar;

import java.util.ArrayList;

class Student {
	
	String name;
	int mark;
	
	public Student(String name, int mark) {
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (mark != other.mark)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

public class CheckStudentClass {
	
	public Student[] checkForHighestMarks(int minMark, int numStudents, Student[] studArray) {

		ArrayList<Student> studList = new ArrayList<>();
		
		int currentHighestMark = 0;
		for (int i = 0; i < numStudents; i++) {
			if (minMark < studArray[i].getMark()) {
				if (currentHighestMark < studArray[i].getMark()) {
					studList = new ArrayList<>();
					currentHighestMark = studArray[i].getMark();
					studList.add(studArray[i]);
				}
				else if (currentHighestMark == studArray[i].getMark()) {
					studList.add(studArray[i]);
				}
			}
		}
		Student[] arrayToReturn = new Student[studList.size()];
		arrayToReturn = studList.toArray(arrayToReturn);
		return arrayToReturn;
	}

}
