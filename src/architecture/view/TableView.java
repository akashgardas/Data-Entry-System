package architecture.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Window for showing the records in the form of tables.
 * Provides separate tables for UG records and PG records.
 * Uses {@link JTable} and {@link DefaultTableModel} for dynamic table.
 */
public class TableView extends JFrame {
	
	/**
	 * Serial Version: 9998L
	 */
	public static final long serialVersionUID = 9998L;
	
	/**
	 * Panel for UG related contents.
	 */
	private JPanel UGPanel;
	
	/**
	 * Panel for PG related contents.
	 */
	private JPanel PGPanel;
	
	/**
	 * Dynamic table for UG records.
	 */
	private DefaultTableModel defaultTableUG;
	
	/**
	 * UG records table.
	 */
	private JTable tableUG;
	
	/**
	 * Dynamic table for PG records.
	 */
	private DefaultTableModel defaultTablePG;
	
	/**
	 * PG records table.
	 */
	private JTable tablePG;
	
	/**
	 * Columns headings. {Roll No, Name, Course, Department}.
	 */
	private String[] colData;
	
	/**
	 * Empty rows for initializing tables.
	 */
	private String[][] rowData;
	
	// Constructor
	/**
	 * Creates an instance of the class with all the elements set at their places.
	 * Resizable is set to false;
	 */
	public TableView() {
		setTitle("Table View");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2,0));
		setResizable(true);
		
//		rowData = new String[][] {
//	            {"1", "Alice", "B.Tech", "Computer Science"},
//	            {"2", "Bob", "M.Tech", "Electronics"},
//	            {"3", "Charlie", "B.Sc", "Physics"},
//	            {"4", "Diana", "MBA", "Management"}
//	        };
		
		rowData = new String[][] {};
		colData = new String[] {"Roll No", "Name", "Course", "Department"};

		// UG Panel
		UGPanel = new JPanel();
		UGPanel.setLayout(new BorderLayout());
		JLabel headingUG = new JLabel("UG Records");
		headingUG.setFont(new Font("Arial", Font.BOLD, 20));
		UGPanel.add(headingUG, BorderLayout.NORTH);
//		UGPanel.add(new JLabel("UG Records"));
		defaultTableUG = new DefaultTableModel(rowData, colData);
		tableUG = new JTable(defaultTableUG);
		JScrollPane scrollPaneUG = new JScrollPane(tableUG);
		UGPanel.add(scrollPaneUG, BorderLayout.CENTER);
//		UGPanel.add(scrollPaneUG);
		add(UGPanel);
		
		PGPanel = new JPanel();
		PGPanel.setLayout(new BorderLayout());
		JLabel headingPG = new JLabel("PG Records");
		headingPG.setFont(new Font("Arial", Font.BOLD, 20));
		PGPanel.add(headingPG, BorderLayout.NORTH);
//		PGPanel.add(new JLabel("PG Records"));
		defaultTablePG = new DefaultTableModel(rowData, colData);
		tablePG = new JTable(defaultTablePG);
		JScrollPane scrollPanePG = new JScrollPane(tablePG);
		PGPanel.add(scrollPanePG, BorderLayout.CENTER);
//		PGPanel.add(scrollPanePG);
		add(PGPanel);
	}
	
	/**
	 * Adds record to {@link #tableUG}.
	 * @param rowData Takes {@link String[]}.
	 * Strings in order: {Roll No, Name, Course, Department}.
	 */
	public void addRowUG(String[] rowData) {
		defaultTableUG.addRow(rowData);
	}
	
	/**
	 * Adds record to {@link #tablePG}.
	 * @param rowData Takes {@link String[]}.
	 * Strings in order: {Roll No, Name, Course, Department}.
	 */
	public void addRowPG(String[] rowData) {
		defaultTablePG.addRow(rowData);
	}
	
	/**
	 * Sets Location of the Table View to with reference to another.
	 * @param frame Frame which should be used as reference.
	 */
	public void setViewLocationRelativeTo(JFrame frame) {
		setLocation(frame.getX() + frame.getWidth() + 5, frame.getY() - 50);
	}

	/**
	 * Clears all the rows.
	 */
	public void clearTables() {
		defaultTableUG.setRowCount(0);
		defaultTablePG.setRowCount(0);
	}
}
