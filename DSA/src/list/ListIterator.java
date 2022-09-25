package list;

/**
 * An Iterator which goes in both directions.
 * 
 * @author Matthew Cipriotti
 *
 */
public interface ListIterator<E> extends Iterator<E> {
	
	/**
	 * @return true if there is a value prior to the implicit cursor
	 */
	boolean hasPrevious();
	
	/**
	 * @return the value prior to implicit cursor and move implicit cursor
	 * Pre: hasPrevious() is true
	 */
	E previous();
	
	/**
	 * Remove value last obtained by a call to next() or previous()
	 * Pre: next() or previous() has been called since the last call to remove()
	 */
	void remove();
	
	/**
	 * Method that inserts the given value just prior to the implicit cursor position
	 */
	void add(E value);
	
	/**
	 * Method that swaps the two values adjacent to the implicit cursor.
	 * Pre: hasNext() and hasPrevious() are both true.
	 */
	void swap();
	
}
