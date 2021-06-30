package my.edu.utar;


enum WatchStates {setHrs, setMins, Altimeter, Time }

enum WatchEvents { pressMode, pressSet }

public class FSMWatch {
	
	private WatchStates currentWatchState = WatchStates.Time;
    private String watchDisplay = "Showing Time";
    private int currentHrs = 0;
    private int currentMins = 0;
    
    public FSMWatch(WatchStates currentWatchState, String watchDisplay,
    		int currentHrs,int currentMins) {
    	this.currentWatchState = currentWatchState;
    	this.watchDisplay = watchDisplay;
    	this.currentHrs = currentHrs;
    	this.currentMins = currentMins;
    }
	
    public WatchStates getCurrentWatchState() {
		return currentWatchState;
	}

	public void setCurrentWatchState(WatchStates currentWatchState) {
		this.currentWatchState = currentWatchState;
	}

	public String getWatchDisplay() {
		return watchDisplay;
	}

	public void setWatchDisplay(String watchDisplay) {
		this.watchDisplay = watchDisplay;
	}

	public int getCurrentHrs() {
		return currentHrs;
	}

	public void setCurrentHrs(int currentHrs) {
		this.currentHrs = currentHrs;
	}

	public int getCurrentMins() {
		return currentMins;
	}

	public void setCurrentMins(int currentMins) {
		this.currentMins = currentMins;
	}

	
    public void processEvent(WatchEvents eventToDo)
    {
        if (eventToDo == WatchEvents.pressMode)
        {
            switch (currentWatchState)
            {
                case Time:
                    watchDisplay = "Showing Altimeter";
                    currentWatchState = WatchStates.Altimeter;
                    break;
                case Altimeter:
                    watchDisplay = "Showing Time";
                    currentWatchState = WatchStates.Time;
                    break;
                case setHrs:
                    watchDisplay = "Showing Set Mins";
                    currentWatchState = WatchStates.setMins;
                    break;
                case setMins:
                    watchDisplay = "Showing Time";
                    currentWatchState = WatchStates.Time;
                    break;
            }
        }
        else if (eventToDo == WatchEvents.pressSet)
        {
            switch (currentWatchState)
            {
                case Time:
                    watchDisplay = "Showing Set Hrs";
                    currentWatchState = WatchStates.setHrs;
                    break;
                case Altimeter:
                    break;
                case setHrs:
                    if (++currentHrs > 23) currentHrs = 0;
                    break;
                case setMins:
                    if (++currentMins > 59) currentMins = 0;
                    break;
            }
        }
    }	
}


