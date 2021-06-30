package my.edu.utar;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String input = scanner.next();
		try{
			double number = Double.parseDouble(input);
			System.out.println("Result: " + number);
		}catch(NumberFormatException e){
			System.out.println("Invalid input.");
		}
		scanner.close();
	}
}
