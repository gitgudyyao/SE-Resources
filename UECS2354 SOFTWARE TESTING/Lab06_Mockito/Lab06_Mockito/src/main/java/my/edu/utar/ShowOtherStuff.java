package my.edu.utar;

class Student {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}
}

interface MoreStuff {
	int firstMethod();
	Student getStudent();
	int[] getIntArray();
	void secondMethod(String message);
	void thirdMethod(String message);
}

interface ReturnStuff {
	String methodWithArgs(int x, String s1, String s2);
}

public class ShowOtherStuff {
	
	MoreStuff ms;
	ReturnStuff rs;
	
	public void setMoreStuff(MoreStuff ms) {
		this.ms = ms;
	}
	
	public void setReturnStuff(ReturnStuff rs) {
		this.rs = rs;
	}
	
	public int someMethod() {
		int defaultValue = 5;
		int result;
		
		int[] retArray = ms.getIntArray();
		System.out.print("Array contents : ");
		for (int i = 0; i < retArray.length; i++)
			System.out.print(retArray[i] + " ");
		System.out.println();
		
		Student stud = ms.getStudent();
		System.out.println ("Student name : " + stud.getName());
		
		try {
			result = ms.firstMethod() + 10;
			return result;
		}
		catch (RuntimeException re) {
			return defaultValue;
		}
	}
	
	public void anotherMethod() {

		ms.secondMethod("dog");
		ms.secondMethod("cat");
		ms.secondMethod("Great");
		ms.secondMethod("cat");
		ms.secondMethod("dog");
		ms.secondMethod("cat");
	}
	
	public void demoArgumentMatchers(int x, String s1, String s2) {
		System.out.print ("Calling methodWithArgs with : ");
		System.out.println (x + " " + s1 + " " + s2);
		String result = rs.methodWithArgs(x, s1, s2);
		System.out.println ("result returned : " + result);
	}

}
