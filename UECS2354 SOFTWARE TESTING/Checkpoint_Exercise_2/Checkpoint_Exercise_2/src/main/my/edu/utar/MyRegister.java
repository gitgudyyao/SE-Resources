package my.edu.utar;

import java.time.Year;

class checkoutObject{
	
	public int pickABook(){		
		
		int year = Year.now().getValue(); // set year to current year, i.e. 2017
		
		// randomly pick a book by author_name and return the year published
		
		return year;
	}
	
	public void updateRecord(boolean proceed){
		// update the book record
	}
}

public class MyRegister {
	
	checkoutObject co;
	
	public MyRegister(){		
	}

	public MyRegister(checkoutObject co){
		this.co=co;
	}
	
	public int getCurrentYear(){
		return Year.now().getValue();
	}
	
	public void borrowBook(){
		int year;
		boolean proceed;
		
		year = co.pickABook();
		
		if((getCurrentYear() - year) < 5)
			proceed = true;
		else
			proceed = false;
		co.updateRecord(proceed);
	}
}
