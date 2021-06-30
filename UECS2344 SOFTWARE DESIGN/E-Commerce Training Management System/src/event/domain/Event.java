package event.domain;

import java.util.List;
import java.util.ArrayList;

public class Event {
	private String title;
	private String theme;
	private String venue;
	private String date;
	private List<Talk> talks;
	private List<Guest> guests;
	
	public Event(String title,String theme,String venue,String date) {
		this.title = title;
		this.theme = theme;
		this.venue = venue;
		this.date = date;
		talks = new ArrayList<Talk>();
		guests = new ArrayList<Guest>();
	}
	
	public void addGuest(Guest aGuest) {
		guests.add(aGuest);
	}
	
	public void addTalk(Talk aTalk) {
		talks.add(aTalk);
	}
	
	public String getTitle() {		
		return title;
	}
	
	public int getNumberOfGuest() {
		return guests.size();
	}
	
	public List<Guest> getAllGuest(){
		return guests;
	}
	
	public int getNumberOfTalk() {
		return talks.size();
	}
	
	public List<Talk> getAllTalk(){
		return talks;
	}

	public Guest selectGuest(int index) {
		return guests.get(index);
	}
}
