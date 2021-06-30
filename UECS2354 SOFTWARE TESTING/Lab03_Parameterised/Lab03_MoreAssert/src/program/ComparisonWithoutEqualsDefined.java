package program;
class Student {
	private String name;
	private int age;

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
}

public class ComparisonWithoutEqualsDefined {
	
	public static void main(String[] args) {
		String s1 = new String("dog");
		String s2 = s1;
		String s3 = new String("dog");
		if (s1 == s2) 
			System.out.println ("s1 and s2 are refering to the same String object");
		else
			System.out.println ("s1 and s2 are NOT refering to the same String object");

		if (s1 == s3) 
			System.out.println ("s1 and s3 are refering to the same String  object");
		else
			System.out.println ("s1 and s3 are NOT refering to the same String object");

		if (s1.equals(s2)) 
			System.out.println ("String objects referred to by s1 and s2 have identical values");

		if (s1.equals(s3)) 
			System.out.println ("String objects referred to by s1 and s3 have identical values");
		
		Student stud1 = new Student("Ah Beng", 25);
		Student stud2 = stud1;
		Student stud3 = new Student("Ah Beng", 25);
		
		if (stud1 == stud2)
			System.out.println ("stud1 and stud2 are refering to the same Student object");
		else
			System.out.println ("stud1 and stud2 are NOT refering to the same Student object");
		
		if (stud1 == stud3)
			System.out.println ("stud1 and stud3 are refering to the same Student object");
		else
			System.out.println ("stud1 and stud3 are NOT refering to the same Student object");
		
		if (stud1.equals(stud2)) 
			System.out.println ("Student objects referred to by stud1 and stud2 have identical instance variable values");
		else
			System.out.println ("Student objects referred to by stud1 and stud2 DO NOT have identical instance variable values");
		
		if (stud1.equals(stud3)) 
			System.out.println ("Student objects referred to by stud1 and stud3 have identical instance variable values");
		else
			System.out.println ("Student objects referred to by stud1 and stud3 DO NOT have identical instance variable values");
	}

}
