package courses.domain;

import java.util.List;

public class Controller {

	private IDataStore dataLists;

	public Controller(IDataStore dataLists) {
		this.dataLists = dataLists;
	}

	public void addCourse(String title, String code) {
		Course course = new Course(title, code);
		dataLists.addCourse(course);
	}

	public int getNumberOfCourses() {
		return dataLists.getNumberOfCourses();
	}

	public List<Course> getAllCourses() {
		return dataLists.getAllCourses();
	}

	public Course selectCourse(String code) {
		return dataLists.searchCourse(code);
	}


	public boolean checkStudentInCourse(Course selectedCourse, 
                                                String name) {
		return selectedCourse.isStudentEnrolled(name);
	}

	public void enrollStudent(Course selectedCourse, String name, int id) {
		Student aStudent = new Student(name, id);
		selectedCourse.enroll(aStudent);
	}
	
	public Student searchStudent(String name)
	{
		return dataLists.searchStudent(name);
	}
	
	public void addStudent(String name, int id)
	{
		Student student = new Student(name, id);
		dataLists.addStudent(student);
	}

	public void setCourseList(IDataStore dataLists)
	{
		this.dataLists = dataLists;
	}
}
