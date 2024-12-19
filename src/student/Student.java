package student;

import java.util.Scanner;
import java.io.*;

/**
 * Represents a student in the data entry system.
 * This class stands as a base for UG and PG students.
 * @since 1.0
 */
public class Student implements Serializable {
	/**
	 * Name of the student
	 */
	public String name;
	/**
	 * Roll number of the student
	 */
	public String rollNo;
	/**
	 * Course of the student
	 */
	public String course;
	/**
	 * Department of the student
	 */
	public String department;
	
	/**
	 * Serial Version
	 * @since 2.0
	 */
	public static final long serialVersionUID = 9991L;
	
	/**
	 * Scanner made transient
	 * @since 2.0
	 */
	protected transient Scanner sc;
	
	/**
	 * Creates a {@link java.util.Scanner} object used in reading student record
	 */
	public Student() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Creates instance of the class by taking all the values.
	 * @param name Name of the student.
	 * @param rollNo Roll No of the student.
	 * @param course Course of the Student.
	 * @param department Department of the Student.
	 */
	public Student(String name, String rollNo, String course, String department) {
		this.name = name;
		this.rollNo = rollNo;
		this.course = course;
		this.department = department;
		
		sc = new Scanner(System.in);
	}
	
	/**
	 * Reads student details
	 */
	public void readData() {
		System.out.print("Enter Name: ");
		name = sc.nextLine();
		System.out.print("Enter Roll No: ");
		rollNo = sc.nextLine();
		System.out.print("Enter Course: ");
		course = sc.nextLine();
		System.out.print("Enter Department: ");
		department = sc.nextLine();
	}
	
	/**
	 * Prints student details
	 */
	public void printData() {
		System.out.println("Name: " + name);
		System.out.println("Roll No: " + rollNo);
		System.out.println("Course: " + course);
		System.out.println("Department: " + department);
	}
	
	/**
	 * To get the type of Student.
	 * @return Returns class name as String.
	 */
	public String getType() {
		return "Student";
	}
}
