package my.edu.utar;


public class PartitionExample {
	
	
	public String getGrade(int mark) {
		
		if (mark < 0 || mark > 100)
			throw new IllegalArgumentException("Mark out of range");
		if (mark < 51)
			return "F";
		else if (mark < 61)
			return "D";
		else if (mark < 71)
			return "C";
		else if (mark < 81)
			return "B";
		else 
			return "A";
	}
	
	public double calculateTax(int salary) {
		
		if (salary < 0)
			throw new IllegalArgumentException("Salary cannot be negative");
		
		if (salary <= 20000)
			return 0.1*salary;
		else if (salary <= 40000)
			return 2000 + 0.15*(salary-20000);
		else if (salary <= 80000)
			return 5000 + 0.20*(salary-40000);
		else 
			return 13000 + 0.30*(salary-80000);
	}

}
