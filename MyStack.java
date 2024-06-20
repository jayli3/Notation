import java.util.ArrayList;

/**
 * Implementation of a generic Stack using ArrayList.
 * Implements the StackInterface.
 *
 * @param <T> the type of elements stored in the stack
 * @author JLi
 */

public class MyStack<T> implements StackInterface<T> {
	private ArrayList<T> stack;
	private int size;
	
	/**
     * Constructs a stack with a specified maximum size.
     *
     * @param number the maximum number of elements the stack can hold
     */
	public MyStack(int number) {
		stack = new ArrayList<T>();
		size = number;
	}
	
	/**
     * Constructs a stack with a default maximum size of 50.
     */
	public MyStack() {
		this(50);
	}
	
	/**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
	public boolean isFull() {
		return stack.size() >= size;
	}
	
	/**
     * Removes and returns the element from the top of the stack.
     *
     * @return the element removed from the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Empty Stack");
		}
		return stack.remove(stack.size() - 1);
	}

	/**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Empty Stack");
		}
		return stack.get(stack.size() - 1);
	}

	/**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     */
	public int size() {
		return stack.size();
	}

	/**
     * Pushes an element onto the top of the stack.
     *
     * @param e the element to be pushed onto the stack
     * @return true if the element was successfully pushed, false otherwise
     * @throws StackOverflowException if the stack is full
     */
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Stack is full");
		}
		return stack.add(e);
	}

	/**
     * Returns a string representation of the elements in the stack.
     *
     * @return a string representation of the stack elements
     */
	public String toString() {
		StringBuffer stackString = new StringBuffer();
		for (T item : stack) {
			stackString.append(item);
		}
		return stackString.toString();
	}
	
	/**
     * Returns a string representation of the elements in the stack,
     * separated by the specified delimiter.
     *
     * @param delimiter the delimiter to use between elements
     * @return a string representation of the stack elements with delimiter
     */
	public String toString(String delimiter) {
		StringBuffer stackString = new StringBuffer();
		for (int i = 0; i < stack.size(); i++) {
			stackString.append(stack.get(i));
			if (i < stack.size() - 1) {
				stackString.append(delimiter);
			}
		}
		return stackString.toString();
	}
	
	/**
     * Fills the stack with elements from the provided ArrayList.
     * Makes a copy of the ArrayList to ensure data integrity.
     *
     * @param list the ArrayList containing elements to be added to the stack
     * @throws StackOverflowException if the stack becomes full during the operation
     */
	public void fill(ArrayList<T> list) throws StackOverflowException {
		ArrayList<T> copyList = new ArrayList<>(list.size());
        for (T item : list) {
            copyList.add(item); 
        }
        
        for (T item : copyList) {
            if (isFull()) {
                throw new StackOverflowException("Stack is full");
            }
            stack.add(item);
        }
		
	}
}
