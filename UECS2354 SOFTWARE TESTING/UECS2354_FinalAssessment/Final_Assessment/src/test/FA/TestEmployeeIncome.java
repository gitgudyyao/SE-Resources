package FA;

import static org.junit.Assert.assertEquals;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestEmployeeIncome {

// Methods to test calculateBonus()
	@Test
	@Parameters(method = "calculateBonusParameter")
	public void calculateBonusTest(double salary, double salesAmount, double bonus)
	{
		EmployeeIncome income = new EmployeeIncome();
		double actualBonus = income.calculateBonus(salary, salesAmount);
		assertEquals(actualBonus, bonus, 0.001);
	}
	private Object[] calculateBonusParameter()
	{
		return new Object[] {
				//assume salary is RM 1500
				new Object[] {1500, 0, 1500},
				new Object[] {1500, 1000, 1600},
				
				new Object[] {1500, 1001, 1650.15},
				new Object[] {1500, 2000, 1800},
				
				new Object[] {1500, 2001, 1900.2},
				new Object[] {1500, 3000, 2100},
				
				new Object[] {1500, 3001, 2250.25},
				new Object[] {1500, 5000, 2750},
				
				new Object[] {1500, 5001, 3000.3},
		};
	}	
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="calculateBonusInvalidParameter") 
	public void calculateBonusInvalid(double salary, double salesAmount) {
		EmployeeIncome INC = new EmployeeIncome();
		INC.calculateBonus(salary, salesAmount);
		
	}
	private Object[] calculateBonusInvalidParameter() {
		return new Object[] {
			new Object[] {1500, -1},
		};
	}
	
	
// Methods to test getRevisedSalary()
	@Test
	@Parameters(method ="getRevisedSalaryParameter")

	public void getRevisedSalaryTest(String name, String position, double RevisedSalary)
	{
		Employee employeeMock = mock(Employee.class);
		when (employeeMock.EmployeeDetails(anyString())).thenReturn(position);
		
		EmployeeIncome air = new EmployeeIncome(employeeMock);
		air.calculateIncome(name);
		
		double actualSalary= air.getRevisedSalary(1500.0);
		assertEquals(actualSalary,RevisedSalary, 0.001);
	}
	
	private Object[] getRevisedSalaryParameter() {
		return new Object[] {
			new Object[] {"Bob Tucker", "Junior executive", 1800.0},
			new Object[] {"Bobby Tucker", "Senior executive", 2000.0},
			new Object[] {"Billy Tucker", "Manager", 2200.0},
		};
	}
	
	
	
// Methods to test updatePosition()
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="updatePositionInvalidParameter")
	public void updatePositionTestInvalid(double salesAmount) {

	Employee employeeMock = mock(Employee.class);
	when (employeeMock.getSalesAmount()).thenReturn(salesAmount);
	
	EmployeeIncome ats = new EmployeeIncome(employeeMock);
	ats.calculateIncome(anyString());
	ats.updatePosition();
		
	}
	private Object[] updatePositionInvalidParameter() {
		return new Object[] {
			new Object[] {-1.0}
	};
	}
	
	@Test
	@Parameters(method ="updatePositionParameter")
	public void updatePositionTest(String position,double salesAmount,String expectedPosition)
	{
		Employee employeeMock = mock(Employee.class);
		when (employeeMock.EmployeeDetails(anyString())).thenReturn(position);
		when (employeeMock.getSalesAmount()).thenReturn(salesAmount);
		
		EmployeeIncome ats = new EmployeeIncome(employeeMock);
		ats.calculateIncome(anyString());
		ats.updatePosition();

		verify(employeeMock).updatePosition(expectedPosition);
	}

	private Object[] updatePositionParameter(){
		return new Object[] {
			new Object[] {"Junior executive",0,"Junior executive"},
			new Object[] {"Junior executive",999,"Junior executive"},
			new Object[] {"Junior executive",1000,"Senior executive"},
			new Object[] {"Junior executive",4999,"Senior executive"},
			new Object[] {"Senior executive",5001,"Manager"}
		};
	}


	
	
	
}
