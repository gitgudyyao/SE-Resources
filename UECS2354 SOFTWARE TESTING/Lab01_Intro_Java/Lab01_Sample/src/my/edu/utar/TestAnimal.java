package my.edu.utar;
public class TestAnimal {

	public static void main(String[] args){
		Dog dog1 = new Dog();
		Bird bird1 = new Bird("Betty");
		
		dog1.walk();
		bird1.eat(bird1.name);
		bird1.fly();
	}
	
}
