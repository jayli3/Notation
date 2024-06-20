/**
 * Exception thrown when a push operation is attempted on a full stack.
 * This exception indicates that the stack cannot accommodate any more elements.
 * 
 * @author JLi
 */

public class StackOverflowException extends Exception {
	/**
     * Constructs a new StackOverflowException with a default error message.
     * The default message is "Push method is called on full stack".
     */
	public StackOverflowException() {
		super("Push method is called on full stack");
	}
	
	/**
     * Constructs a new StackOverflowException with the specified detail message.
     *
     * @param message a custom error message that provides more detail about the stack overflow condition.
     */
	public StackOverflowException(String message) {
		super(message);
	}
}
