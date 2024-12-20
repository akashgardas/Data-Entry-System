package architecture.controller;

import architecture.model.StudentManager;
import architecture.view.EntryView;
import architecture.view.TableView;
import student.Student;
import exception.*;

import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Controller class from MVC architecture that controls Model and View.
 * Defines various functions for handling the coordination between user and storage system.
 */
public class RecordController {
	/**
	 * Instance of {@link StudentManager} for handling business layer.
	 */
	private StudentManager model;
	
	/**
	 * Instance of {@link EntryView} for user interactions for details entry.
	 */
	private EntryView entryView;
	
	/**
	 * Instance of {@link TableView} for displaying records.
	 */
	private TableView tableView;
	
	/**
	 * True if the {@link TableView} is updated with the records stored previously.
	 */
	private boolean updated;
	
	/**
	 * True if the new records are stored into the storage.
	 */
	private boolean saved;
	
	// Constructor
	/**
	 * Constructs MVC model with initial entities.
	 * Adds anonymous Actions listeners to the components in the View.
	 * @param model	Model to be handled by the controller.
	 * @param entryView	User interactions view to be handled by the controller.
	 * @param tableView Table to be handled by the controller.
	 */
	public RecordController(StudentManager model, EntryView entryView, TableView tableView) {
		this.model = model;
		this.entryView = entryView;
		this.tableView = tableView;
		tableView.setViewLocationRelativeTo(entryView);
		saved = true;
		
		entryView.getAddButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addRecord();
			}
		});	
		
		entryView.getClearButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		
		entryView.getViewButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!updated) {
					tableView.clearTables();

					for(Student record: model.getRecordsUG()) {
						String[] values = new String[] {record.rollNo, record.name, record.course, record.department};
						tableView.addRowUG(values);
					}
					
					for(Student record: model.getRecordsPG()) {
						String[] values = new String[] {record.rollNo, record.name, record.course, record.department};
						tableView.addRowPG(values);
					}
					
					updated = true;
				}
			}
		});
		
		entryView.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.saveRecords();
				saved = true;
			}
		});
		
		entryView.getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int conformation = JOptionPane.YES_OPTION;
				if(!saved) {
					conformation = JOptionPane.showConfirmDialog(entryView, "Exit without saving?", "Conformation", JOptionPane.YES_NO_OPTION);
					if(conformation == JOptionPane.YES_OPTION)
						System.exit(0);
				}
				else
					System.exit(0);
			}
		});
	}
	
	/**
	 * Method to start the controller.
	 * Sets the visibility of components to true.
	 */
	public void start() {
		entryView.setVisible(true);
		tableView.setVisible(true);
	}
	
	/**
	 * Clears the fields of the currently selected Tab.
	 */
	protected void clearFields() {
		String tabName = getTabName();
		
		switch(tabName) {
		case "Bachelor"-> entryView.getBachelorPanel().clearFields();
		case "PhD"-> entryView.getPhDPanel().clearFields();
		case "Master"-> entryView.getMasterPanel().clearFields();
		case "Scientist"-> entryView.getScientistPanel().clearFields();
		}
	}
	
	/**
	 * Adds record to {@link StudentManager} and to {@link TableView}. It will not save the record to storage. 
	 */
	private void addRecord() {
		String tabName = getTabName();
		String[] values;
		
		try {
			switch (tabName) {
			case "Bachelor":
				values = entryView.getBachelorPanel().getFields();
				model.addRecordUG(values);
				tableView.addRowUG(values);
				break;
				
			case "PhD":
				values = entryView.getPhDPanel().getFields();
				model.addRecordPhD(values);
				tableView.addRowPG(values);
				break;
				
			case "Master":
				values = entryView.getMasterPanel().getFields();
				model.addRecordMaster(values);
				tableView.addRowPG(values);
				break;
				
			case "Scientist":
				values = entryView.getScientistPanel().getFields();
				model.addRecordScientist(values);
				tableView.addRowPG(values);
				break;
			}

			saved = false;
		}
		catch (IncompleteFieldsException e) {
			JOptionPane.showMessageDialog(entryView, "Please fill all the fields.", "InputError", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Initializes the storage with sample records.
	 * CAUTION: Use this method only once for the initialization.
	 * If multiple times used, same records will be added again.
	 */
	private void initializerCode() {
		// Add 5 UG students (Bachelor)
        model.addRecordUG(new String[]{"101", "Alice", "BSc Computer Science", "Computer Science", "IT", "Tech Institute"});
        model.addRecordUG(new String[]{"102", "Bob", "BSc Physics", "Physics", "Physical Sciences", "Tech Institute"});
        model.addRecordUG(new String[]{"103", "Charlie", "BSc Mathematics", "Mathematics", "Pure Sciences", "Science Academy"});
        model.addRecordUG(new String[]{"104", "David", "BSc Chemistry", "Chemistry", "Chemical Sciences", "Science Academy"});
        model.addRecordUG(new String[]{"105", "Eve", "BSc Biology", "Biology", "Life Sciences", "Bio Institute"});

        // Add 6 PG students
        // PhD Students
        model.addRecordPhD(new String[]{"201", "Frank", "PhD in AI", "Computer Science", "AI in Healthcare", "Dr. Smith"});
        model.addRecordPhD(new String[]{"202", "Grace", "PhD in Quantum Physics", "Physics", "Quantum Computing", "Dr. Johnson"});

        // Master Students
        model.addRecordMaster(new String[]{"301", "Hannah", "MSc Data Science", "Computer Science", "Data Analytics", "Customer Insights"});
        model.addRecordMaster(new String[]{"302", "Ivan", "MSc Applied Mathematics", "Mathematics", "Optimization Techniques", "Transportation Models"});

        // Scientist Students
        model.addRecordScientist(new String[]{"401", "Judy", "Research in Chemistry", "Chemistry", "Organic Chemistry"});
        model.addRecordScientist(new String[]{"402", "Kyle", "Research in Biotechnology", "Biology", "Gene Therapy"});
        
        saved = false;
	}
	
	/**
	 * Calls {@link initializerCode}
	 */
	public void initializeRecordsInFiles() {
		initializerCode();
	}
	
	/**
	 * Gets name of the Tab that is selected.
	 * @return Name of the currently selected Tab.
	 */
	private String getTabName() {
		return entryView.getTabs().getSelectedComponent().getName();
	}
}
