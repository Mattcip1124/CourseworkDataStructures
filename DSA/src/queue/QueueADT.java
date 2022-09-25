package queue;

/**
 * A FIFO List
 * 
 * @author Matthew Cipriotti
 *
 */
public interface QueueADT<E> {

	/**
	 * Put the given value at the end of this queue
	 * 
	 * @param value The value to be added.
	 */
	void add(E value);
	
	/**
	 * Method that returns the value at front of this queue, or null if empty.
	 * 
	 * @return The value at the front or null.
	 */
	E peek();
	
	/**
	 * Method that removes the value at the front of the queue.
	 * 
	 * @return The removed value.
	 * Pre: This queue is not empty.
	 */
	E remove();
	
	/** @return true iff this QueueADT is empty */
	boolean isEmpty();
	 
	/** Clear this QueueADT */
	void clear();
	
	/**
	 * Method that returns the size of this list.
	 * @return The size
	 */
	int size();
}
