package student.pg;

import student.*;

/**
 * A class that supports student records for PhD students
 * @since 1.0
 */
public class PhD extends Student {
	/**
	 * Serial Version
	 * @since 2.0
	 */
	public static final long serialVersionUID = 9993L;
	
	/**
	 * Stores result of the PG student
	 */
	public String resultPG;
	
	/**
	 * All the publications are stored here
	 */
	public String publications;
	
	/**
	 * Topic the PhD student
	 */
	public String topic;
	
	/**
	 * Supervisor of the topic
	 */
	public String supervisor;
	
	/**
	 * Creates instance of the class with default values.
	 */
	public PhD() {}
	
	/**
	 * Creates instance of the class by taking the values.
	 * @param name Name of the student.
	 * @param rollNo Roll No of the student.
	 * @param course Course of the student.
	 * @param department Department of the student.
	 * @param topic Topic of the student.
	 * @param supervisor Supervisor of the student.
	 */
	public PhD(String name, String rollNo, String course, String department, String topic, String supervisor) {
		super(name, rollNo, course, department);
		this.topic = topic;
		this.supervisor = supervisor;
	}
	
	@Override
	public void readData() {
		super.readData();
		System.out.print("Enter Topic: ");
		topic = super.sc.nextLine();
		System.out.print("Enter Supervisor: ");
		supervisor = super.sc.nextLine();
	}
	
	@Override
	public void printData() {
		super.printData();
		System.out.println("Topic: " + topic);
		System.out.println("Supervisor: " + supervisor);
	}
	
	@Override
	public String getType() {
		return "PG";
	}
}
