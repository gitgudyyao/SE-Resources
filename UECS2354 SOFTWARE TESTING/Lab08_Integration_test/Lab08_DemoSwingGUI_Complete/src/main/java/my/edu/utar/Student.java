package my.edu.utar;

import java.util.Arrays;


public class Student {

	private String name;
	
	private String[] subjectsTaken;
	private int[] subjectMark;
	
	private int valToCompare;
	

	public Student(String name, String[] subjectsTaken, int[] subjectMark) {
		this.name = name;
		this.subjectsTaken = subjectsTaken;
		this.subjectMark = subjectMark;
	}
	
	public Student(Student anotherStudent) { // deep copying
		this.name = new String(anotherStudent.getName());
		String[] anotherSubjectsTaken = anotherStudent.getSubjectsTaken();
		subjectsTaken = new String[anotherSubjectsTaken.length];
		for (int i = 0; i < anotherSubjectsTaken.length; i++) 
			subjectsTaken[i] = new String(anotherSubjectsTaken[i]);
		
		int[] anotherSubjectMark = anotherStudent.getSubjectMark();
		subjectMark = new int[anotherSubjectMark.length];
		for (int i = 0; i < anotherSubjectMark.length; i++) 
			subjectMark[i] = anotherSubjectMark[i];
	}

	public String getName() {
		return name;
	}

	public String[] getSubjectsTaken() {
		return subjectsTaken;
	}

	public int[] getSubjectMark() {
		return subjectMark;
	}

	public int getValToCompare() {
		return valToCompare;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubjectsTaken(String[] subjectsTaken) {
		this.subjectsTaken = subjectsTaken;
	}

	public void setSubjectMark(int[] subjectMark) {
		this.subjectMark = subjectMark;
	}

	public void setValToCompare(int valToCompare) {
		this.valToCompare = valToCompare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(subjectMark);
		result = prime * result + Arrays.hashCode(subjectsTaken);
		return result;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(subjectMark, other.subjectMark))
			return false;
		if (!Arrays.equals(subjectsTaken, other.subjectsTaken))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String returnString = name;
		for (int i = 0; i < subjectsTaken.length; i++) {
			returnString += "\t" + subjectsTaken[i] + ":" + subjectMark[i];
		}
		return returnString;
	}

}




