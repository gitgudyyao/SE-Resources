package event.domain;

import java.util.List;

public class Controller {
	private IEventList eventList;
	
	public void updateGuestStatus(Guest aGuest,String status) {
		aGuest.setReplyStatus(status);
	}
	
	public Guest selectGuest(int index,Event anEvent) {
		return anEvent.getAllGuest().get(index);
	}
	
	public Event selectEvent(int index) {
		return eventList.getAllEvent().get(index);
	}
	
	public int getNumberOfTalk(Event anEvent) {
		return anEvent.getNumberOfTalk();
	}
	
	public List<Talk> getAllTalk(Event anEvent){
		return anEvent.getAllTalk();
	}
	
	public int getNumberOfGuest(Event anEvent) {
		return anEvent.getNumberOfGuest();
	}
	
	public List<Guest> getAllGuest(Event anEvent){
		return anEvent.getAllGuest();
	}
	
	public int getNumberOfEvent() {
		return eventList.getNumberOfEvent();
	}
	
	public List<Event> getAllEvent(){
		return eventList.getAllEvent();
	}
	
	public void addTalk(Event anEvent,String title,String speaker,int duration) {
		Talk aTalk = new Talk(title,speaker,duration);
		anEvent.addTalk(aTalk);
	}
	
	public void addGuest(Event anEvent,String name,String contact) {
		Guest aGuest = new Guest(name,contact);
		anEvent.addGuest(aGuest);
	}
	
	public void addEvent(String title,String theme,String venue,String date) {
		Event anEvent = new Event(title,theme,venue,date);
		eventList.addEvent(anEvent);
	}
	
	public void setEventList(IEventList eventList) {
		this.eventList = eventList;
	}
}
