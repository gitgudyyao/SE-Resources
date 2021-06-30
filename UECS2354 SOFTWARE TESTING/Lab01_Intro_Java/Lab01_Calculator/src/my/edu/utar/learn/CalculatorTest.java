package my.edu.utar.learn;
public class CalculatorTest{
	public static void main(String[] args){
		double[] num = {1,2,3,4,5};
		
		Calculator cal = new Calculator();
		
		System.out.println("Sum of array is " + cal.add(num));
	}
}