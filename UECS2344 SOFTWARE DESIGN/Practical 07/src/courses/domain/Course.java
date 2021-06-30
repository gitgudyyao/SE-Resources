package courses.domain;

import java.util.ArrayList;
import java.util.List;

public class Course 
{
	private String title;

	private String code;

	private List<Student> studentsEnrolled;

	public Course(String title, String code) {
		this.title = title;
		this.code = code;
		studentsEnrolled = new ArrayList<Student>();
	}

	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	public boolean isStudentEnrolled(String name) {
		int size = studentsEnrolled.size();
		boolean isEnrolled = false;
		int i = 0;
		Student aStudent = null;
		while (i<size && !isEnrolled) {
			aStudent = studentsEnrolled.get(i);
			if (aStudent.getName().equals(name))
				isEnrolled = true;
			else
				i++;
		}
		return isEnrolled;
	}

	public void enroll(Student aStudent) {
		studentsEnrolled.add(aStudent);
	}

}
