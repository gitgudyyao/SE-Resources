
public class Calculator {
	public double add(double num1, double num2){
		return num1 + num2;
	}
	
	public double add(double[] numbers){
		double result=0;
		
		for(int i=0; i<numbers.length; i++)
			result += numbers[i];
		
		return result;
	}
	
	public double subtract(double num1, double num2){
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2){
		return num1*num2;
	}
	
	public double divide(double dividend, double divisor){
		return dividend / divisor;
	}
}
