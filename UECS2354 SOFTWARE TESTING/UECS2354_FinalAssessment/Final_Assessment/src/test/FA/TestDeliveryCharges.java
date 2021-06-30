package FA;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestDeliveryCharges {
	
		@Test
		@Parameters(method="getParam")
		public void testGetChargeRate(int distance, int weight, double expected){
			DeliveryCharges DC = new DeliveryCharges();
			double actual = DC.getDeliveryCharge(distance, weight);
			assertEquals(actual, expected, 0);
		}
		
		private Object[] getParam(){
			return new Object[]{
				//error 1
				new Object[] {1,100,2.5},
				new Object[] {25,1500,5.0},
				new Object[] {14,6578,7.5},
				//error 2
				new Object[] {50,1500,9.0},
				//error 3 -101 is out of the maximum
				//new Object[] {101,6000,15.0},
				//error 4 -null should not be allowed
				//new Object[] {null,6000,15.0},
				new Object[] {44,9999,15.00}
			};
		}
		
		@Test(expected=IllegalArgumentException.class)
		@Parameters(method="getParamIllegal")
		public void testInvalidValues(int distance, int weight, double expected){
			DeliveryCharges DC = new DeliveryCharges();
			assertEquals(DC.getDeliveryCharge(distance, weight), expected, 0);
		}

		private Object[] getParamIllegal(){
			return new Object[]{
				//error 5
				new Object[] {0, 1, 2.5},	
				new Object[] {101, 1, 2.5},	
				new Object[] {1, 0, 2.5},
				new Object[] {1, 10000, 2.5},
				//moved to test illegal parameters
				new Object[] {101,6000,15.0},
				new Object[] {null,6000,15.0},
			};
		}
		
	}
