/**
 * Exception thrown when a dequeue operation is attempted on an empty queue.
 * This exception indicates that the queue has no elements to remove.
 * 
 * @author JLi
 */
public class QueueUnderflowException extends Exception {
	/**
     * Constructs a new QueueUnderflowException with a default error message.
     * The default message is "Dequeue is called on an empty queue".
     */
	public QueueUnderflowException() {
		super("Dequeue is called on an empty queue");
	}
	
	/**
     * Constructs a new QueueUnderflowException with the specified detail message.
     *
     * @param message a custom error message that provides more detail about the queue underflow condition.
     */
	public QueueUnderflowException(String message) {
		super(message);
	}
}
