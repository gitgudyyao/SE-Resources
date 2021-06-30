package my.edu.utar;

public class DiscountClass {
	
	private double discountOffer = 0.0;
	
	public double getDiscountOffer() {
		return discountOffer;
	}
	
	public void setDiscount(int purchase) {
		if (purchase  < 0 || purchase > 9000)
			throw new IllegalArgumentException("Invalid purchase value");
		if (purchase > 4000)
			discountOffer = 5.6;
		else if (purchase > 1000)
			discountOffer = 4.2;
		else 
			discountOffer = 3.5;
	}

}
