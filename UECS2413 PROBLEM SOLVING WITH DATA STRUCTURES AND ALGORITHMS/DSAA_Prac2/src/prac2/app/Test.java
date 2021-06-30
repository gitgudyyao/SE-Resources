package prac2.app;

public class Test {
	public static void main(String[] args) {
		

	}

	// Q10
	public static void printNumberV1(int n) {
		System.out.println(n);
		if (n > 0)
			printNumberV1(n - 1);
	}
	
	// Q11
	public static void printNumberV2(int n) {
		if (n > 0)
			printNumberV2(n - 1);
		System.out.println(n);
	}
	
	// Q12
	public static int sumSquare(int n) {
		if (n == 0)
			return 0;
		else
			return n * n + sumSquare(n-1);
	}
	
	// Q13
	public static int pow(int base, int exponent) {
		if (exponent == 0)
			return 1;
		else
			return base * pow(base, exponent - 1);
	}
	
	// Q14
	public static void binaryPrint(int x) {
		if (x > 0) {// x != 0
			binaryPrint(x / 2);
			System.out.println(x % 2);
		}
	}
}
