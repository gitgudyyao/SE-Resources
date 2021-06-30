package test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import program.VariousMethodsClass;

import static junitparams.JUnitParamsRunner.$;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BasicParameterizedDemo {

	@Test
	public void testAddTwoNumbersV1() {
		VariousMethodsClass vmc = new VariousMethodsClass();
		int result = vmc.addTwoNumbers(10, 15);
		assertEquals(25, result);
	}
	
	@Test
	public void testAddTwoNumbersV2() {
		VariousMethodsClass vmc = new VariousMethodsClass();
		int result = vmc.addTwoNumbers(-50, 10);
		assertEquals(-40, result);
	}
	
	@Test
	public void testAddTwoNumbersV3() {
		VariousMethodsClass vmc = new VariousMethodsClass();
		int result = vmc.addTwoNumbers(30, 100);
		assertEquals(130, result);
	}

	@Test
	@Parameters({"10, 15, 25","-50, 10, -40","30, 100, 130"})
	public void paramTestAddTwoNumbersV1(int num1, int num2, int expectedSum) {
		VariousMethodsClass vmc = new VariousMethodsClass();
		int result = vmc.addTwoNumbers(num1, num2);
		assertEquals(expectedSum, result);
	}	
	
	private Object[] getNumbersToAdd() {
		
		return new Object[] {
			new Object[] {10, 15, 25},
			new Object[] {-50, 10, -40},
			new Object[] {30, 100, 130}
		};
	}
	
	@Test
	@Parameters(method = "getNumbersToAdd")
	public void paramTestAddTwoNumbersV2(int num1, int num2, int expectedSum) {
		VariousMethodsClass vmc = new VariousMethodsClass();
		int result = vmc.addTwoNumbers(num1, num2);
		assertEquals(expectedSum, result);
	}
	
	@Test
	@Parameters
	public void paramTestV3(int num1, int num2, int expectedSum){
		VariousMethodsClass vmc = new VariousMethodsClass();
		assertEquals(expectedSum,vmc.addTwoNumbers(num1, num2));
	}
	
	private Object[] parametersForParamTestV3(){
		return new Object[] {
				new Object[] {10, 15, 25},
				new Object[] {-50, 10, -40},
				new Object[] {30, 100, 130}
		};
	}
	
	@Test
	@Parameters(method = "getNumbersToAdd_V2")
	public void paramTestV4(int num1, int num2, int expectedSum){
		VariousMethodsClass vmc = new VariousMethodsClass();
		assertEquals(expectedSum, vmc.addTwoNumbers(num1, num2));
	}
	
	private Object[] getNumbersToAdd_V2(){
		return $(
				$(10, 15, 25),
				$(-50, 10, -40),
				$(30, 100, 130)
		);
	}
}