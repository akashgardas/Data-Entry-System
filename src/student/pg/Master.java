package student.pg;

import student.*;

/**
 * A class that supports student record for Master student
 * @since 1.0
 */
public class Master extends Student {
	/**
	 * Serial Version
	 * @since 2.0
	 */
	public static final long serialVersionUID = 9994L;
	
	/**
	 * Stores result of the PG student
	 */
	public Double resultPG;
	
	/**
	 * All the publications are stored here
	 */
	public String publications;
	
	/**
	 * Specialization of the student 
	 */
	public String specialization;
	
	/**
	 * Project done in the PG course
	 */
	public String project;
	
	/**
	 * Creates instance of the class with default values.
	 */
	public Master() {}
	
	/**
	 * Creates instance of the class by taking all values.
	 * @param name Name of the student.
	 * @param rollNo Roll No of the student.
	 * @param course Course of the student.
	 * @param department Department of the student.
	 * @param specialization Specialization of the student.
	 * @param project Project of the student.
	 */
	public Master(String name, String rollNo, String course, String department, String specialization, String project) {
		super(name, rollNo, course, department);
		this.specialization = specialization;
		this.project = project;
	}
	
	@Override
	public void readData() {
		super.readData();
		System.out.print("Enter Specialization: ");
		specialization = super.sc.nextLine();
		System.out.print("Enter Project: ");
		project = super.sc.nextLine();
	}
	
	@Override
	public void printData() {
		super.printData();
		System.out.println("Specialization: " + specialization);
		System.out.println("Project: " + project);
	}
	
	@Override
	public String getType() {
		return "PG";
	}
}
