package q3a.app;

public class Test {
	public static void main(String args[]) {
		A a = new A(3);
	}
}

class A extends B {
	public A(int n) {
		System.out.println("A’s constructor is invoked.");
	}
}

class B {
	public B() {
		System.out.println("B’s constructor is invoked.");
	}
}