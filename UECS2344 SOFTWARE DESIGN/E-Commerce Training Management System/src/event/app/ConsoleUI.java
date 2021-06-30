package event.app;

import event.domain.*;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
	private Scanner scanner;
	private Controller controller;
	
	public ConsoleUI() {
		scanner = new Scanner(System.in);
		controller = null;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	//UI
	public void start() {
		int choice;
		
		do {
		System.out.println("E-Commerce Training Managament System:");
	    	System.out.println("1. Create a new event record");
	    	System.out.println("2. Add a talk for an event");
	    	System.out.println("3. Add a guest to invite for an event");
	    	System.out.println("4. Update status of invited guests");
	    	System.out.println("5. View all events");
	    	System.out.println("6. View list of talks");
	    	System.out.println("7. View list of guest");
	    	System.out.println("8. Exit");
	    	
	    	System.out.print("Enter your choice (1-8): ");
	    	choice = scanner.nextInt();
	
	    	while (choice < 1 || choice > 8) {
	        	System.out.println("Invalid choice.");
	        	System.out.print("Enter your choice (1-8): ");
	        	choice = scanner.nextInt();
	    	}
	    	//Basic Selection
	    	switch(choice) {
	    		case 1: addEvent(); break;
	    		case 2: addTalk(); break;
	    		case 3: addGuest(); break;
	    		case 4: updateGuestStatus(); break;
	    		case 5: displayAllEvent(); 
	    		case 6: displayTalks(); break;
	    		case 7: displayGuests(); break;
	    		case 8: break;
	    	}
	
	    	System.out.println();
		} while (choice != 8);
	}
	
	public void addEvent() {
		System.out.println("Please enter event title: ");
		String skip = scanner.nextLine();
		String theTitle = scanner.nextLine();

		System.out.println("Please enter event date: ");
		String date = scanner.nextLine();
		
		System.out.println("Please enter event venue: ");
		String venue = scanner.nextLine();

		System.out.println("Please enter event theme: ");
		String theme = scanner.nextLine();
		
		controller.addEvent(theTitle, venue, theme, date);
		System.out.println("Event successfully added!");
		System.out.println();
	}
	
	public void addTalk() {
		Event anEvent = selectEvent();
		if(anEvent != null) {
			System.out.println("Please enter talk's title: ");
			String skip = scanner.nextLine();
			String title = scanner.nextLine();
			
			System.out.println("Please enter talk's speaker: ");
			String speaker = scanner.nextLine();
			
			System.out.println("Please enter talk's duration: ");
			int duration = scanner.nextInt();
			skip = scanner.nextLine();
			
			controller.addTalk(anEvent, title, speaker,duration);
		}
	}

	public void addGuest() {
		Event anEvent = selectEvent();
		if(anEvent != null) {
			System.out.println("Please enter guest's name: ");
			String skip = scanner.nextLine();
			String name = scanner.nextLine();
			
			System.out.println("Please enter guest's contact number: ");
			String contact = scanner.nextLine();
			
			controller.addGuest(anEvent, name, contact);
		}
	}

	public void updateGuestStatus() {
		Guest aGuest = selectGuest();
		
		if(aGuest != null) {
			System.out.println("Please enter the latest status(accepted/rejected): ");
			String skip = scanner.nextLine();
			String status = scanner.nextLine();
			
			while (!"accepted".equalsIgnoreCase(status) && !"rejected".equalsIgnoreCase(status)) {
	        	System.out.println("Invalid status.");
	        	System.out.print("Please enter the latest status(accepted/rejected): ");
	        	status = scanner.nextLine();
	    	}
			
			controller.updateGuestStatus(aGuest,status);
			
			System.out.println("Guest Status successfully updated.");
			System.out.println();
		}
	}
	
	public void displayAllEvent() {
		int count = controller.getNumberOfEvent();
		
		if(count > 0) {
			List<Event> events = controller.getAllEvent();
			
			for(int i = 0;i < count;i++) {
				System.out.println(i+1 + ". " + events.get(i).getTitle());
			}
		}else {
			System.out.println("Error. No event found.");
		}
	}
	
	//Returns Event to fit into updateGuestStatus method
	public Event displayGuests() {
		Event anEvent = selectEvent();
		
		if(anEvent!= null) {
			String skip = scanner.nextLine();
			
			int count = controller.getNumberOfGuest(anEvent);
			if(count > 0) {
				List<Guest> guests = controller.getAllGuest(anEvent);
				
				for(int i = 0;i < count;i++) {
					System.out.println(i+1 + ". " + guests.get(i).getName() + "\t Contact: " + guests.get(i).getContact() + "\t Status: " + guests.get(i).getReplyStatus());
				}
			}else {
				System.out.println("No guest is found in this event.");
			}
			
			System.out.println();
			return anEvent;
		}else {
			return null;
		}
	}
	
	//View all talks
	public void displayTalks() {
		Event anEvent = selectEvent();
		
		if(anEvent != null) {
			String skip = scanner.nextLine();
			
			int count = controller.getNumberOfTalk(anEvent);
			if(count > 0) {
				List<Talk> talks = controller.getAllTalk(anEvent);
				
				for(int i = 0;i < count;i++) {
					System.out.println(i+1 + ". " + talks.get(i).getTitle() + "\t Speaker: " + talks.get(i).getSpeaker() + "\t Duration: " + talks.get(i).getDuration());
				}
			}else {
				System.out.println("No talk is found in this event.");
			}
			
			System.out.println();
		}
	}

	public Event selectEvent() {
		int choice;
		
		if(controller.getNumberOfEvent()>0) {
			displayAllEvent();
			System.out.print("Please select an event according to their index: ");
			choice = scanner.nextInt();
			
			while (choice < 1 || choice > controller.getNumberOfEvent()) {
	        	System.out.println("Invalid choice.");
	        	System.out.print("Please enter your choice (1-" + controller.getNumberOfEvent() +"): ");
	        	choice = scanner.nextInt();
	    	}
	
			return controller.selectEvent(choice-1);
		}else {
			System.out.println("No event found.");
			return null;
		}
	}
	
	public Guest selectGuest() {
		int choice;
		
		Event anEvent = displayGuests();
		
		if(anEvent != null) {
			System.out.print("Please select guest according to index: ");
			choice = scanner.nextInt();
			
			while (choice < 1 || choice > controller.getNumberOfGuest(anEvent)) {
	        	System.out.println("Invalid choice.");
	        	System.out.print("Please enter your choice (1-" + controller.getNumberOfGuest(anEvent) +"): ");
	        	choice = scanner.nextInt();
	    	}
			
			return controller.selectGuest(choice - 1, anEvent);
		}else {
			return null;
		}
	}
	

}
