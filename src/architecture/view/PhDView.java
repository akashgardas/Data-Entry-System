package architecture.view;

import exception.*;

import java.awt.*;
import javax.swing.*;

/**
 * Provides Input Panel view for PhD Student.
 */
public class PhDView extends JPanel {
	
	/**
	 * Serial Version: 9998L
	 */
	public static final long serialVersionUID = 9998L;
	
	/**
	 * Represents the Label in the header.
	 */
	private JLabel headerLabel;
	
	/**
	 * Header Panel to hold header Label.
	 */
	private JPanel headerPanel;
	
	/**
	 * Main Panel to hold labels and input fields.
	 */
	private JPanel mainPanel;
	
	/**
	 * Name Input Field.
	 */
	private JTextField nameField;
	
	/**
	 * Roll No Input Field.
	 */
	private JTextField rollNoField;
	
	/**
	 * Course Input Field.
	 */
	private JTextField courseField;
	
	/**
	 * Department Input Field.
	 */
	private JTextField departmentField;
	
	/**
	 * Topic Input Field.
	 */
	private JTextField topicField;
	
	/**
	 * Supervisor Input Field.
	 */
	private JTextField supervisorField;
	
	// Constructor
	/**
	 * Creates a class instance with {@link BorderLayout} and adds Header and Main Panels.
	 */
	public PhDView() {
		setName("PhD");
		setLayout(new BorderLayout());
		
		// Header Section
		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout());
		headerLabel = new JLabel(" PG - PhD ");
		headerLabel.setFont(new Font("SansSerif", Font.ITALIC, 15));
		headerPanel.add(headerLabel);
		add(headerPanel, BorderLayout.NORTH);
		
		// Main Section
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6, 2, 0, 10));
		
		mainPanel.add(new JLabel("Name: "));
		nameField = new JTextField();
		mainPanel.add(nameField);
		mainPanel.add(new JLabel("Roll No: "));
		rollNoField = new JTextField();
		mainPanel.add(rollNoField);
		mainPanel.add(new JLabel("Course: "));
		courseField = new JTextField();
		mainPanel.add(courseField);
		mainPanel.add(new JLabel("Department: "));
		departmentField = new JTextField();
		mainPanel.add(departmentField);
		mainPanel.add(new JLabel("Topic: "));
		topicField = new JTextField();
		mainPanel.add(topicField);
		mainPanel.add(new JLabel("Supervisor: "));
		supervisorField = new JTextField();
		mainPanel.add(supervisorField);
		
		add(mainPanel, BorderLayout.CENTER);
	}

	/**
	 * To get the text entered in the input fields.
	 * @return Returns the text in an array of Strings.
	 * Order of the fields: {Roll No, Name, Course, Department, Topic, Supervisor}.
	 * @throws IncompleteFieldsException Throws Exception if any of the fields is empty and the method is called.
	 */
	public String[] getFields() throws IncompleteFieldsException {
		if(nameField.getText().isEmpty() || rollNoField.getText().isEmpty() || courseField.getText().isEmpty() || departmentField.getText().isEmpty() || topicField.getText().isEmpty() || supervisorField.getText().isEmpty())
			throw new IncompleteFieldsException("Not all the fields are filled.");
		
		return new String[] {rollNoField.getText(), nameField.getText(), courseField.getText(), departmentField.getText(), topicField.getText(), supervisorField.getText()};
	}
	
	/**
	 * Clears all the input fields by setting them to empty String "".
	 */
	public void clearFields() {
		nameField.setText("");
		rollNoField.setText("");
		courseField.setText("");
		departmentField.setText("");
		topicField.setText("");
		supervisorField.setText("");
	}
}
