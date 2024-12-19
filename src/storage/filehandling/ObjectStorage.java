package storage.filehandling;

import java.util.*;
import java.io.*;
import student.*;

/**
 * Stores records as individual objects in file.
 */
public class ObjectStorage {
	
	/**
	 * Stores file object of the storage file.
	 */
	protected File file;
	
	/**
	 * Input stream for Serializing the objects.
	 */
	protected ObjectOutputStream ostream;
	
	/**
	 * Output stream for De-serializing the objects.
	 */
	protected ObjectInputStream istream;
	
	/**
	 * Creates {@link File} object. Creates the file if does not exists.
	 * @param fileName File name as parameter to which stream to be created.
	 */
	public ObjectStorage(String fileName) {
		try {
			file = new File(fileName);
			if(!file.exists())
				file.createNewFile();
		}
		catch (Exception e) {}
		System.out.println("File path: " + file.getAbsolutePath());
	}
	
	/**
	 * Saves Records to the file.
	 * @param records Takes {@link Student} records list to be stored.
	 * @throws Exception Throws exception if records couldn't be saved or stream couldn't be closed.
	 */
	public void saveRecords(List<Student> records) throws Exception {
		ostream = new ObjectOutputStream(new FileOutputStream(file));
		
		for(Student record: records) {
			ostream.writeObject(record);
		}
		
		ostream.close();
	}
	
	/**
	 * Saves Records to the file.
	 * @param records Takes {@link Student} records list to be stored.
	 * @param append True if records has to be appended.
	 * @throws Exception Throws exception if records couldn't be saved or stream couldn't be closed.
	 */
	public void saveRecords(List<Student> records, boolean append) throws Exception {
		if (!append) 
			this.saveRecords(records);
		else {
			ostream = new ObjectOutputStream(new FileOutputStream(file, true));
			
			for(Student record: records)
				ostream.writeObject(record);
			
			ostream.close();
		}
	}
	
	/**
	 * Saves Records to the file.
	 * @param record Takes {@link Student} record as parameter.
	 * @throws Exception Throws exception if records couldn't be saved or stream couldn't be closed.
	 */
	public void saveRecords(Student record) throws Exception {	
		ostream = new ObjectOutputStream(new FileOutputStream(file, true));
		ostream.writeObject(record);
		ostream.close();
	}
	
	/**
	 * Loads the records from the file.
	 * @return Returns all the records stored in file.
	 * @throws Exception Throws exception if records couldn't be read or stream couldn't be closed.
	 */
	public ArrayList<Student> loadRecords() throws Exception {
		istream = new ObjectInputStream(new FileInputStream(file));
		
		ArrayList<Student> records = new ArrayList<>();
		while(true) {
			try {
				records.add((Student) istream.readObject());
			}
			catch (EOFException e) {
				break;
			}
		}
		
		istream.close();
		
		return records;
	}
}
