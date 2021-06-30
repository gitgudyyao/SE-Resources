package courses.domain;

import java.util.List;

public interface IDataStore {

    public void addCourse(Course course);
    	
    public int getNumberOfCourses();

    public List<Course> getAllCourses();

    public Course searchCourse(String code);
    
    public void addStudent(Student student);
    
    public Student searchStudent(String name);
}
