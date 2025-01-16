package architecture.model;

import student.Student;
import student.ug.*;
import student.pg.*;
import storage.filehandling.ObjectStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages Students, files and storage interactions.
 */
public class StudentManager {
	/**
	 * Stores UG records from the storage into {@link List<Student>}
	 */
	private List<Student> recordsUG;
	
	/**
	 * Stores PG records from the storage into {@link List<Student>}
	 */
	private List<Student> recordsPG;
	
	/**
	 * Connection to UG storage.
	 */
	private ObjectStorage storageUG;
	
	/**
	 * Connection to PG storage.
	 */
	private ObjectStorage storagePG;
	
	// Constructor
	/**
	 * Loads records from the storage files into {@link #recordsUG} and {@link #recordsPG}.
	 * If couldn't load the records, initializes {@link #recordsUG} and {@link #recordsPG} with empty {@link ArrayList}.
	 */
	public StudentManager() {
		storageUG = new ObjectStorage("../MVC_UG_students.txt");
		try {
			recordsUG = storageUG.loadRecords();
		} catch (Exception e) {
			recordsUG = new ArrayList<>();
//			System.out.println("Couldn't load UG records");
//			System.out.println(e.toString());
		}
		
		storagePG = new ObjectStorage("../MVC_PG_students.txt");
		try {
			recordsPG = storagePG.loadRecords();
		} catch (Exception e) {
			recordsPG = new ArrayList<>();
//			System.out.println("Couldn't load PG records");
//			System.out.println(e.toString());
		}
	}
	
	/**
	 * Adds UG Student Record into {@link #recordsUG}.
	 * @param record Take {@link Student} as parameter.
	 */
	public void addRecordUG(Student record) {
		recordsUG.add(record);
	}
	
	/**
	 * Adds UG Student Record into {@link #recordsUG}.
	 * @param values A {@link String[]} with values in order:
	 * {RollNo, Name, Course, Department, Branch, College}.
	 */
	public void addRecordUG(String[] values) {
		recordsUG.add(new Bachelor(values[1], values[0], values[2], values[3], values[4], values[5]));
	}
	
	/**
	 * Adds PG Student Record into {@link #recordsPG}.
	 * @param record Take {@link Student} as parameter.
	 */
	public void addRecordPG(Student record) {
		recordsPG.add(record);
	}
	
	/**
	 * Adds PhD Student Record into {@link #recordsPG}.
	 * @param values A {@link String[]} with values in order:
	 * {RollNo, Name, Course, Department, Topic, Supervisor}.
	 */
	public void addRecordPhD(String[] values) {
		recordsPG.add(new PhD(values[1], values[0], values[2], values[3], values[4], values[5]));
	}
	
	/**
	 * Adds Master Student Record into {@link #recordsPG}.
	 * @param values Takes {@link Student} as parameter.
	 * {RollNo, Name, Course, Department, Specialization, Project}.
	 */
	public void addRecordMaster(String[] values) {
		recordsPG.add(new Master(values[1], values[0], values[2], values[3], values[4], values[5]));
	}
	
	/**
	 * Adds Scientist Student Record into {@link #recordsPG}.
	 * @param values Takes {@link Student} as parameter.
	 * {RollNo, Name, Course, Department, Area}.
	 */
	public void addRecordScientist(String[] values) {
		recordsPG.add(new Scientist(values[1], values[0], values[2], values[3], values[4]));
	}
	
	/**
	 * To get records stored in {@link #recordsUG}.
	 * @return {@link #recordsUG};
	 */
	public List<Student> getRecordsUG() {
		return recordsUG;
	}
	
	/**
	 * To get records stored in {@link #recordsPG}.
	 * @return {@link #recordsPG};
	 */
	public List<Student> getRecordsPG() {
		return recordsPG;
	}
	
	/**
	 * Saves updated {@link #recordsUG} and {@link #recordsPG} Records to the storage.
	 */
	public void saveRecords() {
		try {
			storageUG.saveRecords(recordsUG);
		}
		catch (Exception e) {
			System.out.println("Couldn't save UG Records.");
			System.out.println(e.toString());
		}
		
		try {
			storagePG.saveRecords(recordsPG);
		} catch (Exception e) {
			System.out.println("Couldn't save PG Records.");
			System.out.println(e.toString());
		}
	}
}
