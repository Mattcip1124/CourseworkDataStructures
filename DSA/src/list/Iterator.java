package list;

/**
 * Provide access to values in a list sequentially. Allow client to remove.
 * 
 * @author Matthew Cipriotti
 *
 */
public interface Iterator<E> {
	
	/**
	 * Method that returns true if there are more values.
	 * @return True if there are more values.
	 */
	boolean hasNext();
	
	/**
	 * Method that returns the next value.
	 * @return The next value
	 * Pre: hasNext() is true
	 */
	E next();
	
	/**
	 * Remove the last value obtained by a call to next()
	 * Pre: next() was called at least once since the last call to remove()
	 */
	void remove();
}
