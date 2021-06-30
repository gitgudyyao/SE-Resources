package my.edu.utar;

public class Animal {
	public float weight;
	public String name;
	
	public void eat(String s){
		System.out.println(s + " is eating...");
	}
	
	protected void doNotDisturb(){
		System.out.println("Leave me alone...");
	}
}

class Bird extends Animal{
	public int numberOfWings = 2;
	
	public Bird(String name){
		this.name = name;
	}
	
	public void fly(){
		doNotDisturb();
		System.out.println("I am flying...");
	}
}

class Dog extends Animal{
	public int numberOfLegs = 4;
	
	public void walk(){
		System.out.println("I am walking...");
	}
}