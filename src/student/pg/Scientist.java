package student.pg;

import student.*;

/**
 * A class that supports student record for Scientist
 * @since 1.0
 */
public class Scientist extends Student {
	/**
	 * Serial Version
	 * @since 2.0
	 */
	public static final long serialVersionUID = 9995L;
	
	/**
	 * Stores result of the PG student
	 */
	public String resutlPG;
	
	/**
	 * All the publications are stored here
	 */
	public String publications;
	
	/**
	 * Area of the work
	 */
	public String area;
	
	/**
	 * Creates an instance of the class with default values.
	 */
	public Scientist() {}
	
	/**
	 * Creates instance of the class by taking all the values.
	 * @param name Name of the student.
	 * @param rollNo Roll No of the student.
	 * @param course Course of the student.
	 * @param department Department of the student.
	 * @param area Area of the student.
	 */
	public Scientist(String name, String rollNo, String course, String department, String area) {
		super(name, rollNo, course, department);
		this.area = area;
	}
	
	@Override
	public void readData() {
		super.readData();
		System.out.print("Enter Area: ");
		area = super.sc.nextLine();
	}
	
	@Override
	public void printData() {
		super.printData();
		System.out.println("Area: " + area);
	}
	
	@Override
	public String getType() {
		return "PG";
	}
}
