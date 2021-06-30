package q6.app;

public class ClientTest {
	public static void main(String[] args) {
		PartTimeLecturer PTLec = new PartTimeLecturer("Dr. Law", 123, 12);
	
		System.out.println(PTLec.toString());
		System.out.println(PTLec.salary());
	}
}
