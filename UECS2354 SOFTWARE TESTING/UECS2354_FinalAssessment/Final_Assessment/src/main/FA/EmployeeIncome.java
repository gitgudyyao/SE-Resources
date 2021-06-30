package FA;


public class EmployeeIncome {
	String name="";
	String position="";
	double salary=0;
	double bonus=0;
	double salesAmount=0;
	Employee emp;
	
	//public constructors used for testing purposes
	public EmployeeIncome() {
		emp = new Employee();
	}
	
	public EmployeeIncome(Employee emp) {
		this.emp = emp;
	}
	
	public void calculateIncome (String name) {
			
		position = emp.EmployeeDetails(name);
		emp.calculateIncome();
		salesAmount = emp.getSalesAmount();
	}
	
	// calculate the revised salary based on the position
	public double getRevisedSalary(double salary) {
		double revisedSalary = 0.0;
		
		if (position.equals("Junior executive")) {
			revisedSalary = salary + 300;
		}
		else if (position.equals("Senior executive")) {
			revisedSalary = salary + 500;
		}
		else {
			revisedSalary = salary + 700;
		}
		
		return revisedSalary;
	}
	
	// update employee's position through employee's updatePosition() method 
	public void updatePosition() {
		String newPosition = "";
		if (salesAmount < 0)
			throw new IllegalArgumentException();
		
		if (position.equals("Junior executive")) {
			if (salesAmount >= 1000)
				newPosition = "Senior executive";
			else 
				newPosition = "Junior executive";
		}
		else if (position.equals("Senior executive")) {
			if (salesAmount >= 5000)
				newPosition = "Manager";
			else if (salesAmount >= 1000 && salesAmount < 5000)
				newPosition = "Senior executive";
			else 
				newPosition = "Junior executive";
		}
		else {
			if (salesAmount >= 5000)
				newPosition = "Manager";
			else 
				newPosition = "Senior executive";
		}
		emp.updatePosition(newPosition);
		
	}
	
	
	public double calculateBonus(double salary, double salesAmount) {
		//calculate bonus based on sales amount
		if(salary < 0 || salesAmount < 0) 
			throw new IllegalArgumentException(); 
		
		if(salesAmount<=1000) {
			bonus = salary + (salesAmount * 0.10);
		}
		else if (salesAmount > 1000 && salesAmount <= 2000) {
			bonus = salary + (salesAmount * 0.15);
		}
		else if (salesAmount > 2000 && salesAmount <= 3000) {
			bonus = salary + (salesAmount * 0.20);
		}
		else if (salesAmount > 3000 && salesAmount <= 5000) {
			bonus = salary + (salesAmount * 0.25);
		}
		else {
			bonus = salary + (salesAmount * 0.30);
		}
		
		return bonus;
		
	}
	
}
