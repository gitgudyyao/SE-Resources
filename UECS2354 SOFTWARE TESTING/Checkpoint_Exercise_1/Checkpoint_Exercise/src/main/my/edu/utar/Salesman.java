package my.edu.utar;

public class Salesman {
	
	private String rating;
	
	public String getRating() {
		return rating;
	}
 
	public void setRating(int sales) {
		
		if (sales < 0)
			throw new IllegalArgumentException("Invalid sales value");
		if (sales < 5001)
			rating = "Poor";
		else if (sales < 10001)
			rating = "Average";
		else 
			rating = "Good";
	}
	
}
