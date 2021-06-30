package my.edu.utar;

import java.util.Random;

interface RandomNumberFunctionality {
	public int getRandomInteger(int numLimit);
}

class NewRandomGeneratorClass implements RandomNumberFunctionality {

    Random randomGenerator = new Random();
	
	public int getRandomInteger(int numLimit) {
	    int randomInt = randomGenerator.nextInt(numLimit);
		return randomInt;
	}
}

class DummyRandomNumber implements RandomNumberFunctionality {
	
	int valToReturn;
	
	public DummyRandomNumber(int valToReturn) {
		this.valToReturn = valToReturn;
	}

	public int getRandomInteger(int numLimit) {
		return valToReturn;
	}
}

public class NewRandomAddNumbers {
	
	RandomNumberFunctionality rnf;
	
	public NewRandomAddNumbers(RandomNumberFunctionality rnf) {
		this.rnf = rnf;
	}
	
	public int addTwoNumbers(int num1) {
		int num2 = rnf.getRandomInteger(4);
		System.out.println("Adding " + num1 + " and " + num2);
		return num1 + num2;
	}	
	
	public static void main(String args[]) {		
		
		RandomNumberFunctionality original = new NewRandomGeneratorClass();
		RandomNumberFunctionality dummy = new DummyRandomNumber(5);
		
		System.out.println ("Working with original random functionality");
		NewRandomAddNumbers nr1 = new NewRandomAddNumbers(original);
		System.out.println(nr1.addTwoNumbers(7));
		System.out.println(nr1.addTwoNumbers(8));
		System.out.println(nr1.addTwoNumbers(9));

		System.out.println ("Working with dummy functionality that returns a fixed number");
		NewRandomAddNumbers nr2 = new NewRandomAddNumbers(dummy);
		System.out.println(nr2.addTwoNumbers(7));
		System.out.println(nr2.addTwoNumbers(8));
		System.out.println(nr2.addTwoNumbers(9));		
	}
}
