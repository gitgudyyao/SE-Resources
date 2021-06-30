package courses.app;

import courses.domain.*;

public class CoursesApp {
	
	public static void main(String[] args) {

		IDataStore dataLists = new DataLists();
		
		Controller controller = new Controller(dataLists);

		controller.setCourseList(dataLists);
		
		ConsoleUI userInterface = new ConsoleUI(controller);

		userInterface.setController(controller);

		userInterface.start();
		
    }
}
