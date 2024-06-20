/**
 * Exception thrown when a pop operation is attempted on an empty stack.
 * This exception indicates that the stack does not contain any elements to pop.
 * 
 * @author JLi
 */

public class StackUnderflowException extends Exception {
	/**
     * Constructs a new StackUnderflowException with a default error message.
     * The default message is "Pop method is called on an empty stack".
     */
	public StackUnderflowException() {
		super("Pop method is called on an empty stack");
	}
	
	/**
     * Constructs a new StackUnderflowException with the specified detail message.
     *
     * @param message a custom error message that provides more detail about the stack underflow condition.
     */
	public StackUnderflowException(String message) {
		super(message);
	}
}
