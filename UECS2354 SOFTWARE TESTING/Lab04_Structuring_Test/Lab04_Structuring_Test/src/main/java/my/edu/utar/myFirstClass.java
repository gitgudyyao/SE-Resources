package my.edu.utar;

class Student {
	private String name;
	private int age;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean setAgeV2(int age) {
		if (age < 0 || age > 120)
			return false;
		else {
			this.age = age;
			return true;
		}
	}

	public void setAgeV3(int age) {
		if (age < 0 || age > 120)
			System.out.println("Invalid age range");
		else {
			this.age = age;
		}
	}

	public void setAgeV4(int age) throws IllegalArgumentException {
		if (age < 0 || age > 120)
			throw new IllegalArgumentException("Invalid age range");
		else {
			this.age = age;
		}
	}

	public int addTwoNumbers(int a, int b) {
		return a + b;
	}
}

public class myFirstClass {

}
