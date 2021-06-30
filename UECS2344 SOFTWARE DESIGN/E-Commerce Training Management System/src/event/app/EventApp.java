package event.app;

import event.domain.*;

public class EventApp {

	public static void main(String[] args) {

		//IDataStore dataLists = new DataLists();
		IEventList eventList = new EventList();
		
		Controller controller = new Controller();

		controller.setEventList(eventList);
		
		ConsoleUI eventUI = new ConsoleUI();

		eventUI.setController(controller);

		eventUI.start();
    }
}
