package courses.app;

import java.util.List;
import java.util.Scanner;

import courses.domain.*;

public class ConsoleUI {

	private Scanner scanner;

	private Controller controller;

	public ConsoleUI(Controller controller) {
		scanner = new Scanner(System.in);
		this.controller = controller;
	}

	public void start() {

		int choice;

		do {
		       System.out.println("Do you want to:");
		       System.out.println("1. Display all courses");
		       System.out.println("2. Add new course");
		       System.out.println("3. Check if student enrolled in course");
		       System.out.println("4. Enroll student in course");
		       System.out.println("5. Search for student.");
		       System.out.println("6. Add new tudent.");
		       System.out.println("7. Exit");

			System.out.print("Enter your choice (1-7): ");
			choice = scanner.nextInt();
                  // Clear ENTER key after integer input
		      String skip = scanner.nextLine();

			while (choice < 1 || choice > 7) {
				System.out.println("Invalid choice.");
				System.out.print("Enter your choice (1-7): ");
				choice = scanner.nextInt();
                        // Clear ENTER key after integer input
		            skip = scanner.nextLine();
			}

			switch(choice) {
			case 1: displayAllCourses(); break;
			case 2: addCourse(); break;
			case 3: checkStudentInCourse(); break;
			case 4: enrollStudent(); break;
			case 5: searchStudent(); break;
			case 6: addStudent(); break;
			case 7: break;
			}

			System.out.println();

		} while (choice != 5);
	}

	private void addStudent() 
	{
		System.out.println("Please enter the student's name.");
		String newStudent = scanner.nextLine();
		System.out.println("Please enter the student's ID number.");
		int newStudentId = scanner.nextInt();
		
		controller.addStudent(newStudent, newStudentId);
	}

	private Student searchStudent() 
	{
		System.out.print("Enter student name: ");
		String theName = scanner.nextLine();

		Student SearchedStudent = controller.searchStudent(theName);

		if (SearchedStudent == null)
			System.out.println("No student with the name " + theName 
                                              + " found");
		else
			System.out.println("Name: " 
                                   + SearchedStudent.getName());

		return SearchedStudent;
	}

	public void displayAllCourses() {

		int count = controller.getNumberOfCourses();

		if (count == 0)
			System.out.println("No courses to display");
		else {
			List<Course> theCourses = controller.getAllCourses();

			Course aCourse;
			for (int i=0; i<count; i++) {
				aCourse = theCourses.get(i);
				System.out.println("Code: " + aCourse.getCode()
    						+ "\tTitle: " + aCourse.getTitle());
			}
		}
	}

	public void addCourse() {
		System.out.print("Enter course title: ");
		String theTitle = scanner.nextLine();

		System.out.print("Enter course code: ");
		String theCode = scanner.nextLine();

		controller.addCourse(theTitle, theCode);
		System.out.println("New course created");
		System.out.println();

	}

	private Course selectCourse() {
		System.out.print("Enter course code: ");
		String theCode = scanner.nextLine();

		Course selectedCourse = controller.selectCourse(theCode);

		if (selectedCourse == null)
			System.out.println("No course with code " + theCode 
                                              + " found");
		else
			System.out.println("Title: " 
                                   + selectedCourse.getTitle());

		return selectedCourse;
	}

	public void checkStudentInCourse() {

		Course selectedCourse = selectCourse();

		if (selectedCourse != null) {
			System.out.print("Enter stduent name: ");
			String name = scanner.nextLine();
			if (controller.checkStudentInCourse(selectedCourse, 
                                                        name))
			   System.out.println(name + " is enrolled in course");
			else
			   System.out.println(name + " is not enrolled in course");
		}
	}

	public void enrollStudent() {

		Course selectedCourse = selectCourse();

		if (selectedCourse != null) {
			System.out.print("Enter stduent name: ");
			String name = scanner.nextLine();
			System.out.print("Enter stduent id: ");
			int id = scanner.nextInt();

			controller.enrollStudent(selectedCourse, name, id);
			System.out.println("Student enrolled in course");
		}

		System.out.println();
	}

	public void setController(Controller controller) 
	{
		this.controller = controller;		
	}
}
