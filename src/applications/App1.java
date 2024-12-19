package applications;

import java.util.*;
import student.*;
import entry.*;

/**
 * Data Entry System with arrays as storage space in disk.
 * @version 1.0
 * @author Gardas Akash
 */
public class App1 {
	private static List<Student> records;
	private static RecordEntry recordEntry;
	
	public static void main(String[] args) {
		records = new ArrayList<>();
		recordEntry = new RecordEntry();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of records to enter: ");
		/**
		 * Number of student records to store
		 */
		int numOfRecords = sc.nextInt();
		
		for(int i = 0; i < numOfRecords; i ++) {
			records.add(recordEntry.readRecord());
			System.out.println();
		}
		
		System.out.println("Records: ");
		for(Student record: records) {
			recordEntry.printRecord(record);
			System.out.println();
		}
		
		sc.close();
	}
}
