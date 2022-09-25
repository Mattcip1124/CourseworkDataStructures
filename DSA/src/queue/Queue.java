package queue;
import list.*;

/**
 * A QueueADT using a Linked List. Position 0 is front.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Queue<E> implements QueueADT<E> {

	List<E> values = new LinkedList<E>();
	
	/**
	 * Put the given value at the end of this queue
	 * 
	 * @param value The value to be added.
	 */
	public void add(E value) {
		
		values.add(value);
	}
	
	/**
	 * Method that returns the value at front of this queue, or null if empty.
	 * 
	 * @return The value at the front or null.
	 */
	public E peek() {
		
		if(values.isEmpty())
			return null;
		return values.get(0);
	}
	
	/**
	 * Method that removes the value at the front of the queue.
	 * 
	 * @return The removed value.
	 * Pre: This queue is not empty.
	 */
	public E remove() {
		
		return values.remove(0);
	}
	
	/** @return true iff this QueueADT is empty */
	public boolean isEmpty() {
		return values.isEmpty();
	}
	 
	/** Clear this QueueADT */
	public void clear() {
		values.clear();
	}
	
	/**
	 * Method that prints a String representation of the list.
	 * @return A String representation of the list.
	 */
	public String toString() {
		if(isEmpty()) 
			return "[]";
		String list = "[" + values.get(0);
		for(int i = 1; i < values.size(); i++) {
			E temp =  values.get(i);
			list = list + "," + temp;
			}
		
		return list + "]";
	}
	
	/**
	 * Method that returns the size of this list.
	 * @return The size
	 */
	public int size() {
		return values.size();
	}
}
