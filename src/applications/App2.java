package applications;

import java.util.*;
import student.*;
import entry.*;
import storage.filehandling.*;

/**
 * Data Entry System with files as storage space in disk.
 * @version 2.0
 * @author Gardas Akash
 */
public class App2 {
	private static List<Student> recordsUG;
	private static List<Student> recordsPG;
	private static ObjectStorage storageUG;
	private static ObjectStorage storagePG;
	private static RecordEntry recordEntry;
	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String fileNameUG = "UG_students.txt";
		String fileNamePG = "PG_students.txt";
		
		recordsUG = new ArrayList<>();
		recordsPG = new ArrayList<>();
		storageUG = new ObjectStorage(fileNameUG);
		storagePG = new ObjectStorage(fileNamePG);
		recordEntry = new RecordEntry();
		
		try {
			recordsUG = storageUG.loadRecords();
			recordsPG = storagePG.loadRecords();
		}
		
		catch(Exception e) {
			System.out.println("Couldn't load the records.");
			System.out.println(e.toString());
		}
		
		System.out.println("1. Add Record");
		System.out.println("2. View UG Records");
		System.out.println("3. View PG Records");
		System.out.println("4. View All Records");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1 -> addRecords();
		case 2 -> printUGRecords();
		case 3 -> printPGRecords();
		case 4 -> printRecords();
		}
		
		try {
			storageUG.saveRecords(recordsUG);
			storagePG.saveRecords(recordsPG);
		}
		catch (Exception e) {
			System.out.println("Couldn't save records.");
			System.out.println(e.toString())
			;
		}
		
		System.out.println("EXIT");
	}
	
	public static void addRecords() {
		System.out.println("Enter the number student records: ");
		int noOfRecords = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < noOfRecords; i ++) {
			Student record = recordEntry.readRecord();
			if(record.getType().equals("UG"))
				recordsUG.add(record);
			else if(record.getType().equals("PG"))
				recordsPG.add(record);
		}
	}
	
	public static void printPGRecords() {
		System.out.println("PG Records: ");
		for(Student record: recordsPG) 
			recordEntry.printRecord(record);
	}
	
	public static void printUGRecords() {
		System.out.println("UG Records:");
		for(Student record: recordsUG) {
			recordEntry.printRecord(record);
		}
	}
	
	public static void printRecords() {
		printUGRecords();
		printPGRecords();
	}
}
