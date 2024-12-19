package student.ug;

import student.*;

/**
 * A class that supports student record for Bachelor student
 * @since 1.0
 */
public class Bachelor extends Student {
	/**
	 * Serial Version
	 * @since 2.0
	 */
	public static final long serialVersionUID = 9992L;
	
	/**
	 * Stores result of the UG student
	 */
	public Double resultUG;	// TODO: not used
	
	/**
	 * Branch of the student
	 */
	public String branch;
	
	/**
	 * College of the student
	 */
	public String college;

	/**
	 * Creates instance of the class with default values.
	 */
	public Bachelor() {}
	
	/**
	 * Creates instance of the class by taking all the values.
	 * @param name Name of the student.
	 * @param rollNo Roll No of the student.
	 * @param course Course of the student.
	 * @param department Department of the student.
	 * @param branch Branch of the student.
	 * @param college College of the student.
	 */
	public Bachelor(String name, String rollNo, String course, String department, String branch, String college) {
		super(name, rollNo, course, department);
		this.branch = branch;
		this.college = college;
	}
	
	@Override
	public void readData() {
		super.readData();
		System.out.print("Enter Branch: ");
		branch = super.sc.nextLine();
		System.out.print("Enter College: ");
		college = super.sc.nextLine();
	}
	
	@Override
	public void printData() {
		super.printData();
		System.out.println("Branch: " + branch);
		System.out.println("College: " + college);
	}
	
	@Override
	public String getType() {
		return "UG";
	}
}
