package event.domain;

import java.util.ArrayList;
import java.util.List;

public class EventList implements IEventList{
	private List<Event> events;
	
	public EventList() {
		events = new ArrayList<Event>();
	}
	
	public Event selectEvent(int index) {
		return events.get(index);
	}
	
	public int getNumberOfEvent() {
		return events.size();
	}
	
	public List<Event> getAllEvent(){
		return events;
	}
	
	public void addEvent(Event anEvent) {
		events.add(anEvent);
	}
}
