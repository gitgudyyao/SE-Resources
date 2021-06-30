//Name: Tan Ying Yao
// Student ID: 1703648
package LabTest;

class Traveler{
	
	double point=0;
	String category;
	
	public String initializeTraveler(String username){
		// codes check and return traveler's category based on username
		// there are 3 category:
		//     I) Normal Flyer
		//    II) Seasonal Flyer
		//   III) Frequent Flyer
		return category;
	}
	
	public void startBooking() {
		// codes to start booking airline ticket
		// the accumulated points will be stored in variable point
	}
	
	public double getPoint() {
		return point;
	}
	
	public void updateCategory(String category) {
		// update the traveler's category
	}
}

public class AirlineTicketingSystem {
	String category, username="";
	double point=0;
	Traveler tr;
	
	//public constructors used for testing purposes
	public AirlineTicketingSystem() {
		//TYY
		tr = new Traveler();
	}
	
	public AirlineTicketingSystem(Traveler tr) {
		this.tr = tr;
	}
	
	public void startBooking (String username) {
			
		category = tr.initializeTraveler(username);
		tr.startBooking();
		point = tr.getPoint();
	}
	
	// determine the reward based on the traveler's point
	public String getReward() {
		if (category.equals("Frequent Flyer"))
			return "Free upgrade to business class";
		else if (category.equals("Seasonal Flyer"))
			return "Free seat upgrade";
		else
			return "Free meal upgrade";
	}
	
	// update traveler's category through traveler's updateCategory method
	public void updateCategory() {
		//If Point is negative, throw illegal argument exception
		if (point < 0)
			throw new IllegalArgumentException();
		if (point >= 0 && point <= 1000)
			category = "Normal Flyer";
		else if (point > 1000 && point <= 50000)
			category = "Seasonal Flyer";
		else if (point > 50000)
			//wrong code, Seasonal -> Frequent
			category = "Frequent Flyer";
		tr.updateCategory(category);
	}

	// calculate the final ticket price based on age and month:
	// 1. additional charges during year end
	// 2. discount on other months
	
	public double getTicketPrice(double normalTicketPrice, int age, int month) {
		double FinalTicketPrice = 0.00;
		
		//Conditions: 1) Month cannot be less than 1 OR more than 12
		//2) Age cannot be less than 0 OR more than 100
		//TYY
		
		if (month <= 0 || month >12 || age < 0 || age >100)
			throw new IllegalArgumentException();
		
		if(age < 7){
			if(month == 12)
				FinalTicketPrice = normalTicketPrice;
			else
				FinalTicketPrice = normalTicketPrice * 0.85;
		}
		else if(age < 19){
			if(month == 12)
				FinalTicketPrice = normalTicketPrice * 1.10;
			else
				FinalTicketPrice = normalTicketPrice * 0.90;
		}
		else if(age < 56){
			if(month == 12)
				FinalTicketPrice = normalTicketPrice * 1.25;
			else
				FinalTicketPrice = normalTicketPrice;
		}
		else{
			if(month == 12)
				FinalTicketPrice = normalTicketPrice * 1.15;
			else
				FinalTicketPrice = normalTicketPrice * 0.90;
		}			
		
		return FinalTicketPrice;
	}
}
//Brought to you by Covid-19