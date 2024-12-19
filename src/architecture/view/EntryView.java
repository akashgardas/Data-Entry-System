package architecture.view;

import java.awt.*;
import javax.swing.*;

/**
 * Window for user interactions.
 * Provides window with {@link JTabbedPane} containing tabs {@link BachelorView}, {@link PhDView}, {@link MasterView} and {@link ScientistView} in order.
 * Provides {@link JButton} for Add, Clear, View, Save, Exit operations.
 */
public class EntryView extends JFrame {
	/**
	 * Serial Version: 9996L
	 */
	public static final long serialVersionUID = 9996L;
	
	/**
	 * Header Panel for header elements.
	 */
	private JPanel headerPanel;
	
	/**
	 * For left spacing in the window.
	 */
	private JPanel leftPanel;
	
	/**
	 * For right spacing in the window.
	 */
	private JPanel rightPanel;
	
	/**
	 * Main Panel for main section elements.
	 */
	private JPanel mainPanel;
	
	/**
	 * Footer Panel for footer elements.
	 */
	private JPanel footerPanel;
	
	/**
	 * Sub footer Panel for holding {@link #addButton}.
	 */
	private JPanel footerPanel1;
	
	/**
	 * Sub footer Panel for holding {@link #clearButton}, {@link #viewButton}, {@link #saveButton} and {@link #exitButton}.
	 */
	private JPanel footerPanel2;
	
	/**
	 * TabbedPane for holding input tabs.
	 */
	private JTabbedPane tabs;
	
	/**
	 * Header Label.
	 */
	private JLabel headerLabel;
	
	/**
	 * Add Button.
	 */
	private JButton addButton;
	
	/**
	 * Clear Button.
	 */
	private JButton clearButton;
	
	/**
	 * View Button.
	 */
	private JButton viewButton;
	
	/**
	 * Save Button.
	 */
	private JButton saveButton;
	
	/**
	 * Exit Button.
	 */
	private JButton exitButton;
	
	/**
	 * Input Panel for tab.
	 */
	private BachelorView bachelorPanel;
	
	/**
	 * Input Panel for tab.
	 */
	private PhDView phDPanel;
	
	/**
	 * Input Panel for tab.
	 */
	private MasterView masterPanel;
	
	/**
	 * Input Panel for tab.
	 */
	private ScientistView scientistPanel;
	
	// Constructor
	/**
	 * Creates an instance of the class with all the elements set at their places.
	 * Resizable is set to false;
	 */
	public EntryView() {
		setTitle("Data Entry System");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		// Header Section
		headerPanel = new JPanel();
		headerPanel.setSize(100, 400);
		headerLabel = new JLabel("Entry View");
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		headerPanel.add(headerLabel);
		add(headerPanel, BorderLayout.NORTH);
		
		// Left Section
		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(50, 0));
		add(leftPanel, BorderLayout.WEST);
		
		// Left Section
		rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(50, 0));
		add(rightPanel, BorderLayout.EAST);
		
		// Main Section
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		tabs = new JTabbedPane();
		mainPanel.add(tabs);
		bachelorPanel = new BachelorView();
		tabs.add("Bachelor", bachelorPanel);
		phDPanel = new PhDView();
		tabs.add("PhD", phDPanel);
		masterPanel = new MasterView();
		tabs.add("Master", masterPanel);
		scientistPanel = new ScientistView();
		tabs.add("Scientist", scientistPanel);
		add(mainPanel, BorderLayout.CENTER);
		
		// Footer Section
		footerPanel = new JPanel();
		footerPanel.setLayout(new BorderLayout());
		
		// Footer Section1
		footerPanel1 = new JPanel();
		addButton = new JButton("Add");
		addButton.setName("add");
		addButton.setFont(new Font("Arial", Font.BOLD, 15));
		footerPanel1.add(addButton);
		
		footerPanel.add(footerPanel1, BorderLayout.NORTH);
		
		// Footer Section2
		footerPanel2 = new JPanel();
		footerPanel2.setSize(400, 100);
		clearButton = new JButton("Clear");
		clearButton.setName("clear");
		clearButton.setFont(new Font("Arial", Font.BOLD, 15));
		footerPanel2.add(clearButton);
		viewButton = new JButton("View");
		viewButton.setName("view");
		viewButton.setFont(new Font("Arial", Font.BOLD, 15));
		footerPanel2.add(viewButton);
		saveButton = new JButton("Save");
		saveButton.setName("save");
		saveButton.setFont(new Font("Arial", Font.BOLD, 15));
		footerPanel2.add(saveButton);
		exitButton = new JButton("EXIT");
		exitButton.setName("exit");
		exitButton.setFont(new Font("Arial", Font.BOLD, 15));
		footerPanel2.add(exitButton);
		
		footerPanel.add(footerPanel2, BorderLayout.SOUTH);
//		add(footerPanel2, BorderLayout.SOUTH);
		
		add(footerPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * To get instance of {@link #addButton}.
	 * @return {@link #addButton} from the window.
	 */
	public JButton getAddButton() {
		return addButton;
	}
	
	/**
	 * To get instance of {@link #clearButton}.
	 * @return {@link #clearButton} from the window.
	 */
	public JButton getClearButton() {
		return clearButton;
	}
	
	/**
	 * To get instance of {@link #viewButton}.
	 * @return {@link #viewButton} from the window.
	 */
	public JButton getViewButton() {
		return viewButton;
	}
	
	/**
	 * To get instance of {@link #saveButton}.
	 * @return {@link #saveButton} from the window.
	 */
	public JButton getSaveButton() {
		return saveButton;
	}
	
	/**
	 * To get instance of {@link #exitButton}.
	 * @return {@link #exitButton} from the window.
	 */
	public JButton getExitButton() {
		return exitButton;
	}
	
	/**
	 * To get instance of {@link #bachelorPanel}.
	 * @return {@link #bachelorPanel} from the window.
	 */
	public BachelorView getBachelorPanel() {
		return bachelorPanel;
	}
	
	/**
	 * To get instance of {@link #phDPanel}.
	 * @return {@link #phDPanel} from the window.
	 */
	public PhDView getPhDPanel() {
		return phDPanel;
	}
	
	/**
	 * To get instance of {@link #masterPanel}.
	 * @return {@link #masterPanel} from the window.
	 */
	public MasterView getMasterPanel() {
		return masterPanel;
	}
	
	/**
	 * To get instance of {@link #scientistPanel}.
	 * @return {@link #scientistPanel} from the window.
	 */
	public ScientistView getScientistPanel() {
		return scientistPanel;
	}
	
	/**
	 * To get instance of {@link #tabs}.
	 * @return {@link #tabs} from the window.
	 */
	public JTabbedPane getTabs() {
		return tabs;
	}
}
