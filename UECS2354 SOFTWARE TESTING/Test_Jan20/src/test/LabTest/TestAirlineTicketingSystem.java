//Name: Tan Ying Yao
// Student ID: 1703648

package LabTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestAirlineTicketingSystem {
	
	// ================= Part 1 ======================
	
	// Methods to test getTicketPrice()
	@Test
	@Parameters(method = "getTicketPriceParameter")
	public void getTicketPriceTest(double normalTicketPrice, int age, int month, double expectedTicketPrice)
	{
		//getTicketPriceTest -TYY
		
		AirlineTicketingSystem ats = new AirlineTicketingSystem();
		double actualTicketPrice = ats.getTicketPrice(normalTicketPrice, age, month);
		assertEquals(actualTicketPrice,expectedTicketPrice,0.0);
		
	}
	
//getTicketPriceParameters -TYY
	private Object[] getTicketPriceParameter()
	{
		return new Object[] {
				new Object[] {100,5,12,100.00},
				new Object[] {50,3,2,42.50},
				new Object[] {250,15,12,275.00},
				new Object[] {350,13,11,315.00},
				new Object[] {120,21,12,150.00},
				new Object[] {360,35,2,360.00},
				new Object[] {1000,69,12,1150.00},
				new Object[] {500,96,5,450.00}
		};
	}

	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getTicketPriceInvalidParameter") //getTicketPriceInvalidParameter -TYY
	public void getTicketPriceTestInvalid(double normalTicketPrice, int age, int month) {
		//getTicketPriceTestInvalid -TYY
		AirlineTicketingSystem ATS = new AirlineTicketingSystem();
		double actualTicketPrice = ATS.getTicketPrice(normalTicketPrice, age, month);
		
	}
	//getTicketPriceInvalidParameter -TYY
	private Object[] getTicketPriceInvalidParameter() {
		return new Object[] {
			new Object[] {-1, -1, -1},
			new Object[] {-1, 101, 13}
		};
	}
		
	// ================= Part 2 ======================	
	
	// Methods to test getReward() and updateCategory() TYY
		
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="updateCategoryInvalidParameter")
	public void updateCategoryTestInvalid(double point) {
		//updateCategoryTestInvalid
	Traveler travelerMock = mock(Traveler.class);
	when (travelerMock.getPoint()).thenReturn(point);
	
	AirlineTicketingSystem ats = new AirlineTicketingSystem(travelerMock);
	ats.startBooking(anyString());
	ats.updateCategory();

		
	}
	//updateCategoryInvalidParameter -TYY
	private Object[] updateCategoryInvalidParameter() {
		return new Object[] {
			new Object[] {-1.0}
	};
	}
	

	@Test
	@Parameters(method ="getRewardParameter")
	//getRewardParameter -TYY
	public void getRewardTest(String category, String expectedReward)
	{
		Traveler travelerMock = mock(Traveler.class);
		when (travelerMock.initializeTraveler(anyString())).thenReturn(category);
		
		AirlineTicketingSystem air = new AirlineTicketingSystem(travelerMock);
		air.startBooking(anyString());
		String actualReward= air.getReward();
		assertEquals(actualReward,expectedReward);
	}
	
	private Object[] getRewardParameter()
	{
		return new Object[] {
				new Object[] {"Normal Flyer", "Free meal upgrade"},
				new Object[] {"Seasonal Flyer", "Free seat upgrade"},
				new Object[] {"Frequent Flyer", "Free upgrade to business class"},

		};
	}
	
	//updateCategoryParameter -TYY
	@Test
	@Parameters(method ="updateCategoryParameter")
	public void updateCategoryTest(String category,double point,String expectedCategory)
	{
		Traveler travelerMock = mock(Traveler.class);
		when (travelerMock.initializeTraveler(anyString())).thenReturn(category);
		when (travelerMock.getPoint()).thenReturn(point);
		
		AirlineTicketingSystem ats = new AirlineTicketingSystem(travelerMock);
		ats.startBooking(anyString());
		ats.updateCategory();
//verify -TYY
		verify(travelerMock).updateCategory(expectedCategory);
	}
	//updateCategoryParameter -TYY
	private Object[] updateCategoryParameter(){
		return new Object[] {
			new Object[] {"Normal Flyer",0,"Normal Flyer"},
			new Object[] {"Normal Flyer",1000,"Normal Flyer"},
			new Object[] {"Normal Flyer",1001,"Seasonal Flyer"},
			new Object[] {"Normal Flyer",50000,"Seasonal Flyer"},
			new Object[] {"Normal Flyer",50001,"Frequent Flyer"}
		};
	}
}

// Brought to you by Covid-19