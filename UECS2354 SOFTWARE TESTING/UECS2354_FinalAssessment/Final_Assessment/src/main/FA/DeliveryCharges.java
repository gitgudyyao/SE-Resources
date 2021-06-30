package FA;

public class DeliveryCharges {
	int weight=0;
	int distance=0;
	double charges=0;

	public double getDeliveryCharge(int distance, int weight){
		//throw illegal exceptions
		if (distance <= 0 || distance >100 || weight <= 0 || weight >=10000)
			throw new IllegalArgumentException();
		//fixes caseNO01 by adding proper condition
		if(distance >= 1 && distance < 30){
			if(weight < 1000)
				charges = 2.5;
			else if(weight < 5000)
				charges = 5.0;
			else if(weight < 10000)
				charges = 7.5;
		}
		else{
			if(weight < 1000)
				charges = 4.5;
			else if(weight < 5000)
				//fixes caseNO02 by changing to proper value.
				//charges = 8.5;
				charges = 9.0;
			else if(weight < 10000)
				charges = 15.0;
		}			

		return charges;
	}
}