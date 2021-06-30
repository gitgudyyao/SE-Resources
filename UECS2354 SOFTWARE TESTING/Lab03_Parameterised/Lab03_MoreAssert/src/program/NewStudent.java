package program;
public class NewStudent {
	private String name;
	private int age;

	public NewStudent(String name, int age) {
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

	public boolean equals(Object obj)
	{
		if (obj instanceof NewStudent)
		{
			NewStudent compareStudent = (NewStudent) obj;
			if (name.equals(compareStudent.getName()) 
					&& age == compareStudent.getAge())
				return true;
		}	
		return false;
	}
	
	public static void main(String[] args) {

		NewStudent stud1 = new NewStudent("Ah Beng", 25);
		NewStudent stud2 = stud1;
		NewStudent stud3 = new NewStudent("Ah Beng", 25);
		
		if (stud1 == stud2)
			System.out.println("stud1 and stud2 are refering to the same Student object");
		else
			System.out.println("stud1 and stud2 are NOT refering to the same Student object");
		
		if (stud1 == stud3)
			System.out.println("stud1 and stud3 are refering to the same Student object");
		else
			System.out.println("stud1 and stud3 are NOT refering to the same Student object");
		
		if (stud1.equals(stud2)) 
			System.out.println("Student objects referred to by stud1 and stud2 have identical instance variable values");
		else
			System.out.println("Student objects referred to by stud1 and stud2 DO NOT have identical instance variable values");
		
		if (stud1.equals(stud3)) 
			System.out.println("Student objects referred to by stud1 and stud3 have identical instance variable values");
		else
			System.out.println("Student objects referred to by stud1 and stud3 DO NOT have identical instance variable values");
	}
}
