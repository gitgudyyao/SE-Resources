package q4.app;

public class AccountTest {
	public static void main(String[] args) {
		Account acc = new Account(20000, 1122, 0.045);
		
		acc.withdraw(2500);
		acc.deposit(3000);
		
		System.out.println("Balance: " + acc.getBalance());
		System.out.println("Monthly interest: " + acc.getBalance() * (acc.getAnnualInterest() / 12));
	}
}

class Account {
	private double balance, annualInterestRate;
	private int id;
	
	public Account() {
		
	}
	
	public Account(double balance, int id, double annualInterest) {
		this.balance = balance;
		this.id = id;
		this.annualInterestRate = annualInterest;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getAnnualInterest() {
		return annualInterestRate;
	}
}
