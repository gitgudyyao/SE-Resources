package q3c.app;

class Base {
	void sub() {
		System.out.println("Base");
	}
	
	// method overloading
	void sub(int p) {
		System.out.println(20);
	}
}
class Severn extends Base {
	public static void main(String argv[]) {
		Severn s = new Severn();
		s.sub(15);// calling the overloaded method in Base class
	}
	
	// Method overriding
	void sub(){
		System.out.println("Severn");
	}
}
