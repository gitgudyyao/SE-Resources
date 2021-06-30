package my.edu.utar;

class Customer {
	
    private int loyaltyPoints, extraDiscount, defaultDiscount;
    
    public Customer (int loyaltyPoints, int extraDiscount, int defaultDiscount) {
    	this.loyaltyPoints = loyaltyPoints;
    	this.extraDiscount = extraDiscount;
    	this.defaultDiscount = defaultDiscount;
    }

    public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public int getExtraDiscount() {
		return extraDiscount;
	}

	public int getDefaultDiscount() {
		return defaultDiscount;
	}

	public void processPurchase(boolean haveCard, boolean chooseDiscount, int amountSpent)
    {
		if (amountSpent < 0)
			throw new IllegalArgumentException();
		
        if (haveCard)
        {
            if (chooseDiscount)
                extraDiscount = defaultDiscount;
            else
                loyaltyPoints += amountSpent;
        }
        else if (amountSpent > 100)
            extraDiscount = defaultDiscount;
    }
}

public class DemoDecisionTables {
	
}
