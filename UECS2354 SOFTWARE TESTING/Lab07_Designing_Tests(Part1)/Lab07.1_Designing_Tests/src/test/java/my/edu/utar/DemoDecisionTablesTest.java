package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DemoDecisionTablesTest {
	
	Customer  cus = new Customer(0,0,10);
	
	@Test
	@Parameters({"false,true,0,0,0", "false,false,100,0,0", // rule 1
			"false,true,101,10,0", "false,false,200,10,0", // rule 2
			"true,true,100,10,0", "true,true,101,10,0",  // rule 3
			"true,false,100,0,100", "true,false,101,0,101"}) // rule 4
	public void testProcessPurchaseValidValues
	(boolean haveCard, boolean chooseDiscount, int amountSpent, 
			int expectedDiscount, int expectedLoyaltyPoints) {
		
		cus.processPurchase(haveCard, chooseDiscount, amountSpent);
		assertEquals(expectedDiscount, cus.getExtraDiscount());
		assertEquals(expectedLoyaltyPoints, cus.getLoyaltyPoints());
		
	}	

	@Test(expected=IllegalArgumentException.class)	
	@Parameters({"false,true,-1", "false,false,-2", // rule 1
		"true,false,-4", "true,true,-3"})
	public void testProcessPurchaseInvalidValues(boolean haveCard, boolean chooseDiscount, 
			int amountSpent) 	{
		cus.processPurchase(haveCard, chooseDiscount, amountSpent);
	}

}
