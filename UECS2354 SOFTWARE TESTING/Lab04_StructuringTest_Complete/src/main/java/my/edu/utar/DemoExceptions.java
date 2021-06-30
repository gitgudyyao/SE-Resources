package my.edu.utar;

public class DemoExceptions {

	public static void main(String[] args) {

		Student s = new Student("Muthu", 20);

		System.out.println("Calling setAgeV4 with an invalid parameter value");
		s.setAgeV4(150);

		System.out.println("Calling setAgeV4 again with an invalid parameter value");
		try {
			s.setAgeV4(150);
		} catch (IllegalArgumentException iae) {
			System.out.println("Execute code here to handle the case of exception");
			s.setAgeV4(25);
		}
	}

}
