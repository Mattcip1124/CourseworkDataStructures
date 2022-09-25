package stack;

import list.*;

/**
 * A StackADT using a List. End of List is top of stack.
 * 
 * @author Matthew Cipriotti
 *
 */
public class Stack<E> implements StackADT<E> {

	List<E> values = new LinkedList<E>();
	
	/**
	 * Constructor for Stack objects.
	 * 
	 * @param arrayBased If the list is an ArrayList.
	 */
	public Stack(boolean arrayBased) {
		
		if (arrayBased)
			values = new ArrayList<E>();
	}
	
	/**
	 * Constructor for Stack objects.
	 */
	public Stack() {
		
	}
	
	/**
	 * Put a value on top of the stack.
	 * 
	 * @param value The value to be added.
	 * @return the pushed value
	 */
	public E push(E value) {
		values.add(value);
		return value;
	}
	
	/**
	 * Method that returns top value from this list.
	 * Pre: Stack is not empty
	 */
	public E peek() {
		return values.get(values.size() - 1);
	}
	
	/**
	 * Remove the top value from the stack.
	 * 
	 * @return the value removed.
	 * Pre: Stack is not empty
	 */
	public E pop() {
		return values.remove(values.size() - 1);
	}
	
	/** Clear this StackADT */
	public void clear() {
		values.clear();
	}
	
	/** @return true iff this StackADT is empty */
	public boolean isEmpty() {
		return values.isEmpty();
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
			E temp = values.get(i);
			list = list + "," + temp;
			}
		
		return list + "]";
	}
}
