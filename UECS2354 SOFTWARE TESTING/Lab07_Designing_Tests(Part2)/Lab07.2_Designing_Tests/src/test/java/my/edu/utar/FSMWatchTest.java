package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.FSMWatch;
import my.edu.utar.WatchEvents;
import my.edu.utar.WatchStates;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMWatchTest {
	
	@Test
	@Parameters({"pressSet,setHrs,Showing Set Hrs", "pressMode,Altimeter,Showing Altimeter"}) 	
	public void testTimeState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay) {
		
		FSMWatch fw = new FSMWatch(WatchStates.Time, "Showing Time", 0, 0);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
	}

	@Test
	@Parameters({"pressSet,Altimeter,Showing Altimeter", "pressMode,Time,Showing Time"}) 	
	public void testAltimeterState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay) {
		
		FSMWatch fw = new FSMWatch(WatchStates.Altimeter, "Showing Altimeter", 0, 0);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
	}

	@Test
	@Parameters({"pressSet,setHrs,Showing Set Hrs,5,10,6,10", 
		"pressSet,setHrs,Showing Set Hrs,23,10,0,10", 
		"pressMode,setMins,Showing Set Mins,0,5,0,5"}) 	
	public void testSetHrsState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay,
			int currentHour, int currentMinute, int expectedHour, int expectedMinute) {
		
		FSMWatch fw = new FSMWatch(WatchStates.setHrs, "Showing Set Hrs", currentHour, currentMinute);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
		assertEquals(expectedHour, fw.getCurrentHrs());
		assertEquals(expectedMinute, fw.getCurrentMins());
	}

	@Test
	@Parameters({"pressSet,setMins,Showing Set Mins,5,10,5,11", 
		"pressSet,setMins,Showing Set Mins,5,59,5,00", 
		"pressMode,Time,Showing Time,0,5,0,5"}) 	
	
	public void testSetMinsState(WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay,
			int currentHour, int currentMinute, int expectedHour, int expectedMinute) {
		FSMWatch fw = new FSMWatch(WatchStates.setMins, "Showing Set Mins", currentHour, currentMinute);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
		assertEquals(expectedHour, fw.getCurrentHrs());
		assertEquals(expectedMinute, fw.getCurrentMins());
	}

}
