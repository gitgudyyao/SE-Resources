package my.edu.utar.learn;
public class Calculator{
	public double add(double number1, double number2){
		return number1 + number2;
	}
	
	public double add(double[] numbers){
		double result=0;
		
		for(int i=0; i<numbers.length; i++)
			result += numbers[i];
		
		return result;
	}
}
