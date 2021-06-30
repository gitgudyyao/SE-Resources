package event.domain;

import java.util.List;

public interface IEventList {
	public Event selectEvent(int index);
	public int getNumberOfEvent();
	public List<Event> getAllEvent();
	public void addEvent(Event anEvent);
}
