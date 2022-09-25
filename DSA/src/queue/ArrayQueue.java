package queue;
import list.*;

/**
 * A QueueADT using an ArrayList.
 * 
 * @author Matthew Cipriotti
 *
 */
public class ArrayQueue<E> implements QueueADT<E> {

	List<E> values = new ArrayList<E>();
	int front = 0;
	int back = 0;		//next available position.
	int size = 0;
	
	/**
	 * Method that returns the value at front of this queue, or null if empty.
	 * 
	 * @return The value at the front or null.
	 */
	public E peek() {
		
		if(size == 0)
			return null;
		return values.get(front);
	}
	
	/**
	 * Method that removes the value at the front of the queue.
	 * 
	 * @return The removed value.
	 * Pre: This queue is not empty.
	 */
	public E remove() {
		
		E result = values.get(front);
		front = (front + 1) % values.size();
		size--;
		return result;
	}
	
	/**
	 * Put the given value at the end of this queue
	 * 
	 * @param value The value to be added.
	 */
	public void add(E value) {
		
		if(size == values.size()) {
			values.add(back, value);
			front = (front + 1) % values.size();
		}
		else {
			values.set(back, value);
		}
		back = (back + 1) % values.size();
		size++;
	}
	
	/** @return true iff this QueueADT is empty */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else return false;
				
	}
	 
	/** Clear this QueueADT */
	public void clear() {
		values.clear();
		front = 0;
		back = 0;
		size = 0;
	}
	
	/**
	 * Method that prints a String representation of the list.
	 * @return A String representation of the list.
	 */
	public String toString() {
		if(isEmpty()) 
			return "[]";
		String list = "[" + values.get(front);
		for(int i = front + 1; i != back + 1; i++) {
			if(i == values.size())
				i = 0;
			E temp = values.get(i);
			list = list + "," + temp;
			}
		
		return list + "]";
	}
	
	/**
	 * Method that returns the size of this list.
	 * @return The size
	 */
	public int size() {
		return size;
	}
}
