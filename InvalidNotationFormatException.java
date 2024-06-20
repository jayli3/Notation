/**
 * Exception thrown when a notation format is invalid.
 * This exception is used to indicate errors in the format of
 * infix, postfix, or any other type of notation.
 * 
 * @author JLi
 */

public class InvalidNotationFormatException extends Exception {
	/**
     * Constructs a new InvalidNotationFormatException with a default error message.
     * The default message is "Notation format is incorrect".
     */
	public InvalidNotationFormatException() {
		super("Notation format is incorrect");
	}
	
	/**
     * Constructs a new InvalidNotationFormatException with the specified detail message.
     *
     * @param message a custom error message that provides more detail about the invalid notation format.
     */
	public InvalidNotationFormatException(String message) {
		super(message);
	}

}
