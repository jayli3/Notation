/**
 * Exception thrown when an enqueue operation is attempted on a full queue.
 * This exception indicates that the queue has reached its capacity and cannot accept more elements.
 * 
 * @author JLi
 */
public class QueueOverflowException extends Exception {
	/**
     * Constructs a new QueueOverflowException with a default error message.
     * The default message is "Enqueue is called on a full queue".
     */
	public QueueOverflowException() {
		super("Enqueue is called on a full queue");
	}
	
	/**
     * Constructs a new QueueOverflowException with the specified detail message.
     *
     * @param message a custom error message that provides more detail about the queue overflow condition.
     */
	public QueueOverflowException(String message) {
		super(message);
	}
}
