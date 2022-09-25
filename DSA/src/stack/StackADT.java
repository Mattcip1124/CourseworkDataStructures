package stack;

/**
 * A LIFO List.
 * 
 * @author Matthew Cipriotti
 *
 */
public interface StackADT<E> {

	/**
	 * Put a value on top of the stack.
	 * 
	 * @param value The value to be added.
	 * @return the pushed value
	 */
	E push(E value);
	
	/**
	 * Method that returns top value from this list.
	 * Pre: Stack is not empty
	 */
	E peek();
	
	/**
	 * Remove the top value from the stack.
	 * 
	 * @return the value removed.
	 * Pre: Stack is not empty
	 */
	E pop();
	
	/** Clear this StackADT */
	void clear();
	
	/** @return true iff this StackADT is empty */
	boolean isEmpty();
}
