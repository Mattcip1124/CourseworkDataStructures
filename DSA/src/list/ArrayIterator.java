package list;

/**
 * Iterator for ArrayLists.
 * 
 * @author Matthew Cipriotti
 *
 */
class ArrayIterator<E> implements Iterator<E> {
	
	List<E> list;
	int ndx = -1;			//Position of last value obtained by next()
	
	/**
	 * Constructor for Iterator objects
	 * @param list The list we are iterating through.
	 */
	ArrayIterator(List<E> list) {
		this.list = list;
	}
	
	/**
	 * Method that returns true if there are more values.
	 * @return True if there are more values.
	 */
	public boolean hasNext() {
		return ndx < list.size() - 1;
	}
	
	/**
	 * Method that returns the next value.
	 * @return The next value
	 * Pre: hasNext() is true
	 */
	public E next() {
		ndx++;
		return list.get(ndx);
	}
	
	/**
	 * Remove the last value obtained by a call to next()
	 * Pre: next() was called at least once since the last call to remove()
	 */
	public void remove() {
		list.remove(ndx);
		ndx--;
	}
}
