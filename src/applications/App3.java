package applications;

import architecture.controller.*;
import architecture.model.*;
import architecture.view.*;

/**
 * Data Entry System with MVC architecture with files as storage space in disk.
 * @version 3.0
 * @author Gardas Akash
 */
public class App3 {
	public static void main(String[] args) {
		StudentManager model = new StudentManager();
		EntryView entryView = new EntryView();
		TableView tableView = new TableView();
		RecordController controller = new RecordController(model, entryView, tableView);
		
		/* CAUTION: Run initializer only once for initializing files with sample data. 
		 * Running it multiple times will resultX in multiple initializing. */
//		controller.initializeRecordsInFiles();	
		controller.start();
	}
}
