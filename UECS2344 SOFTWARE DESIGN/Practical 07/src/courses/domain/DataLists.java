package courses.domain;

import java.util.List;
import java.util.ArrayList;

public class DataLists implements IDataStore {

	private List<Course> courses;
	private List<Student> students;
    
	public DataLists() 
	{
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
	}
	
	public void addCourse(Course aCourse) {
		courses.add(aCourse);
	}
		
      public int getNumberOfCourses() {
	      return courses.size();
      }
      public List<Course> getAllCourses() {
	      return courses;
      }

	public Course searchCourse(String code) {
		Course theCourse = null;
		boolean found = false;
		int i = 0;

		while (i<courses.size() && !found) {
			theCourse = courses.get(i);
			if (theCourse.getCode().equals(code))
				found = true;
			else
				i++;
		}

		if (!found)
			theCourse = null;

		return theCourse;
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public Student searchStudent(String name) 
	{
		int i=0;
		boolean found = false;
		Student theStudent = null;
		while (i<students.size() && !found) {
			theStudent = students.get(i);
			if (theStudent.getName().equals(name))
				found = true;
			else
				i++;
		}

		if (!found)
			theStudent = null;

		return theStudent;
	}
}
