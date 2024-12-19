package exception;

/**
 * Exception raises if any input field is empty.
 */
public class IncompleteFieldsException extends Exception {
	/**
	 * Serial Version: 1L
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Initializes the message of the Exception.
	 */
	public IncompleteFieldsException(String msg) {
		super(msg);
	}
}
