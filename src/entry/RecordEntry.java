package entry;

import java.util.Scanner;
import student.*;
import student.ug.*;
import student.pg.*;

/**
 * Provides methods to create student records and to print the student records
 * @since 1.0
 */
public class RecordEntry {
	/**
	 * Scanner reference used in reading a student record
	 */
	Scanner sc;
	
	/**
	 * {@link student.Student} reference for holding student record
	 */
	public Student std;
	
	/**
	 * Creates a {@link java.util.Scanner} object used in reading student record
	 */
	public RecordEntry() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Reads student details for the selected type of student
	 * @return Returns {@link student.Student} object if read successfully, or returns null
	 */
	public Student readRecord() {
		try {
			std = selectStudentType();
			std.readData();
		}
		catch(NullPointerException e) {
			System.out.println("Record not read");
			return null;
		}
		
		return std;
	}
	
	/**
	 * Displays student record with their description
	 * @param student {@link student.Student} reference to hold a student record
	 */
	public void printRecord(Student student) {
		std = student;
		std.printData();
	}
	
	/**
	 * Allows user to select a type of student like Bachelor, Master, PhD, Scientist
	 * @return Returns {@link Student} object
	 * @throws NullPointerException if the selected student type mismatches
	 */
	protected Student selectStudentType() throws NullPointerException {
		int choice;
		System.out.println("1. UG - Bachelor");
		System.out.println("2. PG - Master");
		System.out.println("3. PG - PhD");
		System.out.println("4. PG - Scientist");
		System.out.print("Enter the type of the student: ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1: return new Bachelor();
		case 2: return new Master();
		case 3: return new PhD();
		case 4: return new Scientist();
		default: throw new NullPointerException();
		}
	}
}
