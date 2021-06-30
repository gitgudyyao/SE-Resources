package q5.app;

public class Rectangle {
	private double length, width;
	
	public Rectangle(double init_length, double init_width) {
		length = init_length;
		width = init_width;
	}
	
	public double area() {
		return length * width;
	}
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(12.5, 6.5);
		System.out.println(rect.area());
		
		Box box = new Box(12.5, 6.5, 4.6);
		System.out.println(box.area());
		System.out.println(box.volume());
	}
}

class Box extends Rectangle {
	private double depth;
	
	public Box(double init_length, double init_width, double init_depth) {
		super(init_length, init_width);
		depth = init_depth;
	}
	
	public double area() {
		return super.area() * 6;
	}
	
	public double volume() {
		return super.area() * depth;
	}
}