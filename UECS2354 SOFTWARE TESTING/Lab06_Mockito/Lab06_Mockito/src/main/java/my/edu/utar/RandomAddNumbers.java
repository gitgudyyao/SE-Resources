package my.edu.utar;

import java.util.Random;

class RandomGeneratorClass {

    Random randomGenerator = new Random();
	
	public int getRandomInteger(int numLimit) {
	    int randomInt = randomGenerator.nextInt(numLimit);
		return randomInt;
	}
}

public class RandomAddNumbers {
	
	RandomGeneratorClass rgc;
	
	public RandomAddNumbers(RandomGeneratorClass rgc) {
		this.rgc = rgc;
	}

	public RandomAddNumbers() {
		rgc = new RandomGeneratorClass();
	}

	public int addTwoNumbers(int num1) {
		
		int num2 = rgc.getRandomInteger(4);
		System.out.println("Adding " + num1 + " and " + num2);
		return num1 + num2;
	}
	
	public static void main(String args[]) {

		RandomAddNumbers ran = new RandomAddNumbers();
		System.out.println(ran.addTwoNumbers(7));
		System.out.println(ran.addTwoNumbers(8));
		System.out.println(ran.addTwoNumbers(9));
	}
}
