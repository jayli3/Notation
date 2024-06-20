import java.util.ArrayList;

/**
 * Implementation of a generic Queue using ArrayList.
 * Implements the QueueInterface.
 *
 * @param <T> the type of elements stored in the queue
 * @author JLi
 */

public class MyQueue<T> implements QueueInterface<T> {
	private ArrayList<T> queue;
	private int size;
	
	/**
     * Constructs a queue with a specified maximum size.
     *
     * @param number the maximum number of elements the queue can hold
     */
	public MyQueue(int number) {
		queue = new ArrayList<T>();
		size = number;
	}
	
	/**
     * Constructs a queue with a default maximum size of 50.
     */
	public MyQueue() {
		this(50);
	}
	
	/**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	/**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise
     */
	public boolean isFull() {
		return queue.size() >= size;
	}
	
	/**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element removed from the front of the queue
     * @throws QueueUnderflowException if the queue is empty
     */
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("Queue is Empty");
		}
		return queue.remove(0);
	}
	
	/**
     * Returns the number of elements currently in the queue.
     *
     * @return the number of elements in the queue
     */
	public int size() {
		return queue.size();
	}
	
	/**
     * Adds an element to the rear of the queue.
     *
     * @param e the element to be added to the queue
     * @return true if the element was successfully added, false otherwise
     * @throws QueueOverflowException if the queue is full
     */
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException("Queue is Full");
		}
		return queue.add(e);
	}
	
	/**
     * Returns a string representation of the elements in the queue.
     *
     * @return a string representation of the queue elements
     */
	public String toString() {
		StringBuffer queueString = new StringBuffer();
		for (T item : queue) {
			queueString.append(item);
		}
		return queueString.toString();
	}

	/**
     * Returns a string representation of the elements in the queue,
     * separated by the specified delimiter.
     *
     * @param delimiter the delimiter to use between elements
     * @return a string representation of the queue elements with delimiter
     */
	public String toString(String delimiter) {
		StringBuffer queueString = new StringBuffer();
		for (int i = 0; i < queue.size(); i++) {
			queueString.append(queue.get(i));
			if (i < queue.size() - 1) {
				queueString.append(delimiter);
			}
		}
		return queueString.toString();
	}

	/**
     * Fills the queue with elements from the provided ArrayList.
     * Makes a copy of the ArrayList to ensure data integrity.
     *
     * @param list the ArrayList containing elements to be added to the queue
     * @throws QueueOverflowException if the queue becomes full during the operation
     */
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		ArrayList<T> copyList = new ArrayList<T>();
		for (T item : list) {
			copyList.add(item);
		}
		
		for (T item: copyList) {
			if (isFull()) {
				throw new QueueOverflowException("Queue is Full");
			}
			queue.add(item);
		}
	}

}
