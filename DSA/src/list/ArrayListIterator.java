package list;

/**
 * A List Iterator for ArrayLists
 * 
 * @author Matthew Cipriotti
 *
 */
class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {
	
	//implicit cursor is between positions ndx and ndx + 1
	boolean forward = true;
	
	/**
	 * Constructor for ArrayListIterator objects.
	 * 
	 * @param list The list to be iterated.
	 */
	ArrayListIterator(List<E> list) {
		super(list);
	}
	
	/**
	 * Constructor for ArrayListIterator objects.
	 * 
	 * @param list The list to be iterated.
	 * @param start A starting position.
	 */
	ArrayListIterator(int start, List<E> list) {
		super(list);
		ndx = start - 1;
	}
	
	/**
	 * @return true if there is a value prior to the implicit cursor
	 */
	public boolean hasPrevious() {
		return ndx >= 0;
	}
	
	/**
	 * @return the value prior to implicit cursor and move implicit cursor
	 * Pre: hasPrevious() is true
	 */
	public E previous() {
		forward = false;
		ndx--;
		return list.get(ndx+1);
	}
	
	/**
	 * Remove value last obtained by a call to next() or previous()
	 * Pre: next() or previous() has been called since the last call to remove()
	 */
	public void remove() {
		if(forward)
			ndx--;
		list.remove(ndx+1);
	}
	
	/**
	 * Method that returns the next value. Override from superclass.
	 * @return The next value
	 * Pre: hasNext() is true
	 */
	public E next() {
		forward = true;
		return super.next();
	}
	
	/**
	 * Method that inserts the given value just prior to the implicit cursor position
	 */
	public void add(E value) {
		ndx++;
		list.add(ndx, value);
	}
	
	/**
	 * Method that swaps the two values adjacent to the implicit cursor.
	 * Pre: hasNext() and hasPrevious() are both true.
	 */
	public void swap() {
		E temp = list.get(ndx);
		list.set(ndx, list.get(ndx + 1));
		list.set(ndx + 1, temp);
		
	}
}
